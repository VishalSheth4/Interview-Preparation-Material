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
2. A RAG agent with citations
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
- [ ] Phase 4: Frameworks and MCP (Project 4)
- [ ] Phase 5: Multi-agent systems (Project 5)
- [ ] Phase 6: Evaluation, reliability, safety (Project 6)
- [ ] Phase 7: Production and specialization
