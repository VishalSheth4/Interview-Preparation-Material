# Roadmap to Becoming an Agentic AI Engineer

A phased path of about **6 to 9 months** at 10 to 15 hours a week. Each phase has topics, a project, and a "you're ready when" checkpoint. Tools and frameworks change quickly, so treat specific library names as examples and check current docs before committing to one.

---

## Phase 0: Foundations (Weeks 1-4)

**Python**
- Core language: functions, classes, error handling, virtual environments
- `async`/`await` (agents spend most of their time waiting on APIs)
- Working with JSON, files, and HTTP (`requests`, `httpx`)
- Type hints and **Pydantic** for data validation (essential for structured outputs)

**Developer basics**
- Git and GitHub
- Command line
- Docker basics
- Reading API documentation

**Math and ML (light touch)**
- What embeddings, tokens, and probability distributions are
- You don't need deep math to build agents

**Checkpoint:** you can write a script that calls a web API, parses the JSON, handles errors, and runs asynchronously.

---

## Phase 1: Understand LLMs (Weeks 5-8)

**Concepts**
- How transformers work at an intuitive level
- Tokens, context windows, temperature, top-p
- Why models hallucinate, and their strengths and limits
- Differences between model tiers (small and fast vs. large and capable)
- Cost and latency trade-offs

**Hands-on**
- Call an LLM API directly (Anthropic, OpenAI, or open models via Ollama)
- System prompts vs. user prompts
- Streaming responses
- **Structured outputs:** make the model return valid JSON that matches a schema
- Multi-turn conversation management

**Prompt engineering**
- Clear instructions, examples (few-shot), and constraints
- Chain-of-thought and step-by-step reasoning
- Writing prompts as testable specifications

**Project 1:** a command-line assistant that remembers the conversation, returns structured data (for example, extracting tasks from messy notes), and tracks its own token cost.

**Checkpoint:** you can explain why a prompt failed and fix it systematically.

---

## Phase 2: Tool Use and the Agent Loop (Weeks 9-13)

This is the heart of agentic AI.

**Function calling / tool use**
- Defining tools with clear names, descriptions, and parameter schemas
- The model decides to call a tool, your code executes it, and the result goes back to the model
- Handling multiple and parallel tool calls
- Writing tool descriptions that models use correctly (this matters more than people expect)

**The core agent loop**

```
goal -> think -> choose action -> execute tool -> observe result -> repeat until done
```

- Stop conditions and maximum iteration limits
- Error recovery when a tool fails

**Common tools to build**
- Web search and page fetching
- Code execution (sandboxed)
- File read/write
- Database queries
- Calculator, calendar, and email APIs

**Reasoning patterns**
- **ReAct:** interleaved reasoning and acting
- **Plan-and-execute:** write a plan first, then run it
- **Reflection:** the agent critiques and revises its own output
- **Task decomposition:** breaking big goals into subtasks

**Project 2:** build an agent loop **from scratch with no framework**: a research agent that takes a question, searches the web, reads pages, and writes a cited summary.

**Checkpoint:** you understand every line of your own agent loop. Building it by hand first makes frameworks far easier to learn.

---

## Phase 3: Memory, Knowledge, and Context (Weeks 14-18)

**Context engineering**
- What to put in the context window and what to leave out
- Summarizing and compressing long histories
- Managing tool outputs that are too large

**Retrieval-Augmented Generation (RAG)**
- Embeddings and vector similarity
- Chunking strategies for documents
- Vector databases (pgvector, Chroma, Qdrant, Pinecone)
- Hybrid search (keyword + semantic) and re-ranking
- Citing sources and reducing hallucinations

**Memory types**
- **Working memory:** the current context
- **Episodic memory:** past interactions and what happened
- **Semantic memory:** facts and preferences about the user or domain
- **Procedural memory:** learned instructions and workflows

**Project 3:** a "chat with your documents" agent that retrieves from a knowledge base, cites sources, and remembers user preferences across sessions.

**Checkpoint:** you can explain why retrieval failed for a given query and improve it.

### Project 3 in Detail: End-to-End RAG Application

Build Project 3 as a complete, production-style RAG app. Work through the 19 stages below in order. Each stage ends with a concrete "done when" test, so you always know whether to move on.

**Suggested stack** (swap pieces freely and check current docs for versions):
- Python + `pydantic-settings` for configuration
- `pypdf` and `python-docx` for loading documents
- HuggingFace `sentence-transformers` for embeddings
- **Qdrant** as the vector database
- **Ollama** (local) or **OpenAI** (hosted) as the LLM
- **Streamlit** for the chat UI
- Docker and docker-compose for packaging

**Target folder structure**

```
rag-project/
├── .env                      # secrets (never commit)
├── .env.example              # template with placeholder values
├── .gitignore
├── requirements.txt
├── README.md
├── Dockerfile
├── docker-compose.yml
├── main.py                   # CLI entry point (ingest, ask)
├── app.py                    # Streamlit chat interface
├── data/
│   ├── raw/                  # original PDF, TXT, DOCX files
│   └── processed/            # cleaned text, chunk dumps for debugging
├── src/
│   ├── config/settings.py    # typed settings loaded from .env
│   ├── ingestion/loaders.py  # PDF / TXT / DOCX loaders
│   ├── preprocessing/cleaner.py
│   ├── chunking/chunker.py
│   ├── embeddings/embedder.py
│   ├── vectorstore/qdrant_store.py
│   ├── indexing/indexer.py   # ingestion → chunks → embeddings → Qdrant
│   ├── retrieval/
│   │   ├── retriever.py      # similarity search
│   │   ├── hybrid.py         # keyword + vector fusion
│   │   └── reranker.py
│   ├── llm/client.py         # Ollama / OpenAI behind one interface
│   ├── pipeline/rag_pipeline.py
│   ├── memory/conversation.py
│   └── evaluation/           # golden set, metrics, runners
└── tests/
```

#### Stage-by-stage plan

| # | Stage | What to build and learn | Done when |
|---|---|---|---|
| 1 | **RAG fundamentals and project overview** | Why RAG exists (fresh, private knowledge without retraining), the flow: ingest → chunk → embed → store → retrieve → generate. Draw the architecture diagram yourself. | You can explain the full flow and where each failure can happen |
| 2 | **Project folder structure** | Create the layout above with empty modules and `__init__.py` files. One responsibility per module. | `python -c "import src"` works |
| 3 | **Python environment and dependencies** | `venv`, `requirements.txt`, pinned versions, `.gitignore`. | A fresh clone installs and runs with 3 commands |
| 4 | **Configuration management** | `settings.py` using Pydantic settings plus `.env`: model names, chunk size, Qdrant URL, top-k, LLM provider. No hardcoded values anywhere else. | Changing `.env` changes behavior with no code edits |
| 5 | **Document ingestion (PDF, TXT, DOCX)** | One loader per format returning a common `Document(text, metadata)` object with source filename and page number. Handle corrupt and empty files gracefully. | A folder of mixed files loads with clear errors for bad ones |
| 6 | **Text cleaning and preprocessing** | Normalize whitespace, strip headers/footers and page numbers, fix hyphenated line breaks, remove junk characters. Keep the original text in metadata. | Before/after samples look clean and nothing meaningful was lost |
| 7 | **Document chunking strategies** | Fixed-size, recursive (paragraph → sentence → word), sentence-based, and semantic chunking. Tune chunk size and overlap. Keep metadata (source, page, chunk index) on every chunk. | You can justify your chunk size using retrieval results, not guesses |
| 8 | **Embeddings with HuggingFace** | Load a `sentence-transformers` model, embed in batches, normalize vectors, and cache results. Learn that the query and the documents must use the same model. | Similar sentences score higher than unrelated ones in a quick test |
| 9 | **Qdrant vector database integration** | Run Qdrant (Docker), create a collection with the right vector size and distance metric, upsert points with payload metadata, query by vector. | You can insert, search, and delete points from code |
| 10 | **Document indexing pipeline** | Wire stages 5 to 9: load → clean → chunk → embed → upsert. Use deterministic IDs so re-running doesn't create duplicates. Batch upserts and show progress. | Re-indexing the same folder doesn't double your collection |
| 11 | **Retriever and similarity search** | A `Retriever` class: embed the query, search top-k, apply a score threshold, return chunks with scores and sources. | Sensible chunks come back for 10 hand-written questions |
| 12 | **LLM integration (Ollama / OpenAI)** | One `LLMClient` interface with two implementations. Write a prompt that says: answer only from the context, say "I don't know" when it isn't there, cite sources. Add timeouts and retries. | Switching provider is a one-line setting |
| 13 | **RAG pipeline orchestration** | `RAGPipeline.ask(question)` → retrieve → build prompt with numbered context → generate → return `{answer, sources, scores}`. Log every step. | The pipeline returns answer and sources for a question end to end |
| 14 | **`main.py` execution and CLI** | Commands such as `python main.py ingest data/raw` and `python main.py ask "..."` using `argparse` or Typer. | A non-developer can follow the README to index and ask |
| 15 | **Streamlit chat interface** | Chat UI with message history, a sidebar for uploads and settings, a spinner, and expandable source panels. Cache the pipeline and models so they load once. | You can chat with your documents in the browser |
| 16 | **Source citations and conversation memory** | Show `[1]`, `[2]` markers that map to file and page. Keep a sliding window of recent turns and **rewrite follow-up questions** ("what about its price?") into standalone queries before retrieval. | Follow-up questions work and every claim links to a source |
| 17 | **Advanced retrieval** | **Hybrid search** (BM25 keyword + vector, merged with Reciprocal Rank Fusion), **metadata filters** (by file, date, type), and a **cross-encoder reranker** applied to the top 20-50 candidates. | Each technique has measured gains, or you drop it |
| 18 | **Evaluation, testing, and debugging** | Build a golden set of 30 to 50 questions with expected source chunks. Measure retrieval hit rate and MRR, then answer quality (faithfulness to context, relevance). Add unit tests for loaders, chunker, and retriever. Add a debug mode that prints retrieved chunks and the final prompt. | You can say "hit rate went from 62% to 78% after reranking" |
| 19 | **Docker, README, and production deployment** | `Dockerfile` for the app, `docker-compose.yml` for app + Qdrant (+ Ollama), health checks, persistent volumes, environment-based config, and a README with architecture, setup, usage, and limitations. | `docker compose up` gives a working app on a clean machine |

#### Core pipeline skeleton (stage 13)

```python
from dataclasses import dataclass

@dataclass
class Chunk:
    text: str
    source: str
    page: int | None
    score: float

class RAGPipeline:
    def __init__(self, retriever, llm, top_k: int = 5):
        self.retriever = retriever
        self.llm = llm
        self.top_k = top_k

    def ask(self, question: str) -> dict:
        chunks: list[Chunk] = self.retriever.search(question, top_k=self.top_k)
        if not chunks:
            return {"answer": "I couldn't find relevant information.", "sources": []}

        context = "\n\n".join(
            f"[{i}] ({c.source}, p.{c.page})\n{c.text}"
            for i, c in enumerate(chunks, start=1)
        )
        prompt = (
            "Answer the question using ONLY the context below. "
            "Cite sources like [1]. If the answer is not in the context, say you don't know.\n\n"
            f"Context:\n{context}\n\nQuestion: {question}\nAnswer:"
        )
        answer = self.llm.generate(prompt)
        return {"answer": answer, "sources": chunks}
```

#### Common RAG pitfalls to watch for
- **Chunks too big or too small:** big chunks dilute meaning, tiny chunks lose context. Test several sizes.
- **Mixing embedding models** between indexing and querying, which silently ruins results.
- **No evaluation set**, so you can't tell whether a change helped.
- **Trusting retrieved text as instructions.** Documents can contain prompt injection, so treat context as data, not commands.
- **Skipping metadata**, which makes citations and filtering impossible later.
- **Ignoring "no answer" cases.** A good RAG app says "I don't know" instead of guessing.

#### Suggested timeline (fits Weeks 14-18)
- **Week 14:** stages 1 to 6 (setup, config, ingestion, cleaning)
- **Week 15:** stages 7 to 10 (chunking, embeddings, Qdrant, indexing)
- **Week 16:** stages 11 to 14 (retriever, LLM, pipeline, CLI)
- **Week 17:** stages 15 to 17 (UI, citations, memory, advanced retrieval)
- **Week 18:** stages 18 to 19 (evaluation, tests, Docker, README)

**Project 3 deliverable:** a GitHub repo with a working Dockerized app, a README with an architecture diagram, and a short evaluation report showing retrieval metrics before and after your improvements.

---

## Phase 4: Frameworks and Protocols (Weeks 19-22)

Now that you understand the mechanics, frameworks will make sense instead of feeling like magic.

**Agent frameworks to try (pick one or two deeply)**
- **Claude Agent SDK**
- **LangGraph** (stateful, graph-based workflows)
- **LlamaIndex** (strong for data and RAG)
- **CrewAI / AutoGen** (multi-agent teams)
- **OpenAI Agents SDK**

**MCP (Model Context Protocol)**
- The standard way to connect agents to tools and data sources
- Using existing MCP servers
- Building your own MCP server that exposes your tools

**Workflow patterns**
- Prompt chaining, routing, parallelization
- Orchestrator-workers
- Evaluator-optimizer loops

> **Principle:** start with the simplest workflow that works. Many problems don't need a fully autonomous agent. A fixed pipeline with one or two LLM calls is cheaper and more reliable. Reach for autonomy only when the path to the goal can't be predicted in advance.

**Project 4:** rebuild Project 2 in a framework and compare. Then build an MCP server that gives an agent access to something real (your notes, a database, or a calendar).

---

## Phase 5: Multi-Agent Systems (Weeks 23-26)

- When multiple agents help (parallel work, specialization, separate contexts) and when they just add cost and complexity
- Orchestrator + subagent patterns
- Handoffs between agents
- Shared state vs. message passing
- Preventing agents from looping, contradicting each other, or duplicating work
- Human-in-the-loop checkpoints for approval

**Project 5:** a multi-agent system, such as a software-task agent with a planner, a coder, and a reviewer, or a market-research team with a lead agent delegating to researchers.

---

## Phase 6: Reliability, Evaluation, and Safety (Weeks 27-32)

This phase separates demos from production systems.

**Evaluation**
- Build a test set of realistic tasks with expected outcomes
- Measure task success rate, cost, latency, and number of steps
- LLM-as-judge grading, and its biases
- Regression testing every time you change a prompt or model
- Evaluating the **trajectory** (the steps taken), not just the final answer

**Observability**
- Logging every prompt, tool call, and result
- Tracing tools (LangSmith, Langfuse, Arize Phoenix, OpenTelemetry)
- Debugging by replaying failed runs

**Guardrails**
- Input and output validation
- Budget limits on tokens, time, and tool calls
- Retries with backoff, fallbacks to other models
- Confirmation before irreversible actions (sending email, spending money, deleting data)

**Security**
- **Prompt injection:** malicious instructions hidden in web pages, emails, or documents that the agent reads
- Least-privilege permissions for every tool
- Sandboxing code execution
- Protecting secrets and personal data
- Treating all retrieved content as untrusted data, not instructions

**Project 6:** take your best agent and build an evaluation suite, a tracing dashboard, and a red-team test set of at least 20 adversarial inputs, then fix what breaks.

---

## Phase 7: Production and Specialization (Weeks 33+)

**Deployment**
- Wrapping agents in APIs (FastAPI)
- Queues and background jobs for long-running tasks
- Caching, rate limits, and cost optimization (prompt caching, model routing)
- Cloud deployment and CI/CD

**Advanced topics**
- Computer-use and browser agents
- Coding agents
- Voice agents
- Fine-tuning vs. prompting (and when each is worth it)
- Long-running agents with checkpoints and resumability

**Choose a specialty**
- Coding agents, customer support, research and analysis, data/BI agents, workflow automation, or an industry vertical such as finance, healthcare, or legal

---

## Portfolio: What to Show Employers

1. A from-scratch agent loop (shows you understand fundamentals)
2. A full-stack RAG app (Qdrant + LLM + Streamlit + Docker) with citations, hybrid search, and an evaluation report
3. An MCP server
4. A multi-agent system
5. **One project with a published evaluation report.** This is rare and highly valued.
6. A write-up of failures you hit and how you fixed them

Put everything on GitHub with clear READMEs, demos, and honest notes on limitations.

---

## Habits That Speed You Up

- **Build constantly.** Aim for roughly 70% hands-on and 30% reading.
- **Read tracing logs.** Watching what the agent actually did teaches you more than any tutorial.
- **Read engineering write-ups** from AI labs on building effective agents, and follow framework changelogs.
- **Join communities** such as Discord servers, r/LocalLLaMA, and open-source agent repos, and contribute small fixes.
- **Keep a failure journal** of what went wrong and why.

---

## Quick Skill Checklist

| Area | Level to reach |
|---|---|
| Python + async | Comfortable |
| LLM APIs + structured output | Strong |
| Tool use / agent loop | Strong |
| RAG + memory | Solid |
| One framework + MCP | Solid |
| Multi-agent design | Working knowledge |
| Evals + observability | Strong (a differentiator) |
| Security + guardrails | Solid |
| Deployment | Working knowledge |

---

## Progress Tracker

- [ ] Phase 0: Foundations
- [ ] Phase 1: Understand LLMs (Project 1)
- [ ] Phase 2: Tool use and agent loop (Project 2)
- [ ] Phase 3: Memory, RAG, context (Project 3)
  - [ ] Stages 1-6: setup, config, ingestion, cleaning
  - [ ] Stages 7-10: chunking, embeddings, Qdrant, indexing pipeline
  - [ ] Stages 11-14: retriever, LLM integration, pipeline, CLI
  - [ ] Stages 15-17: Streamlit UI, citations and memory, advanced retrieval
  - [ ] Stages 18-19: evaluation and testing, Docker and deployment
- [ ] Phase 4: Frameworks and MCP (Project 4)
- [ ] Phase 5: Multi-agent systems (Project 5)
- [ ] Phase 6: Evaluation, reliability, safety (Project 6)
- [ ] Phase 7: Production and specialization
