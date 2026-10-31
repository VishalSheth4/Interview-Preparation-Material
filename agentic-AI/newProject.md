Project 1: Agentic Data-Quality Incident Triage (Kafka + LLM agents)

Problem: Data-quality breaches generate alerts that humans manually investigate. An agent can do the first-pass triage.

How it works:

A Kafka consumer receives breach events (synthetic risk-data feed).
A supervisor agent routes to specialist tools: SQL query tool (Snowflake or Postgres/DuckDB as a stand-in), runbook retrieval (RAG), and historical-incident lookup.
It produces a root-cause hypothesis plus a recommended action.
Human-in-the-loop: risky actions (e.g., re-run a pipeline) require approval via a simple UI or Slack webhook.

Stack: Java 21 + Spring Boot + Spring AI (or LangChain4j), Kafka, Postgres/pgvector, Docker Compose.

Showcase: idempotent event handling, retries and DLQ, tool-call timeouts, step/token budgets to stop runaway loops, full audit trail of every agent decision.

Resume bullet (fill in real numbers after testing):

Built an agentic incident-triage system that consumes Kafka breach events and uses tool-calling LLM agents (SQL, runbook RAG, incident history) to produce root-cause hypotheses; added human approval gates, loop/token budgets, and an audit log. Achieved [X]% correct first-pass diagnosis on a [N]-incident evaluation set.

Project 2: Secure MCP Server for Enterprise Data Access

Problem: Giving LLMs direct database access is unsafe. MCP is the emerging standard for exposing tools to agents, and you already list MCP in your LLD certification.

How it works:

Build an MCP server exposing a small set of read-only, parameterized tools (e.g., get_portfolio_exposure, compare_risk_factors, list_failed_loads).
Add authentication, per-tool authorization, row-level scoping, rate limiting, and query-cost limits.
Log every tool call with caller identity.
Include a sample client (Claude or any MCP-capable agent) that uses it.

Stack: Java (MCP Java SDK) or Python/TypeScript SDK, Snowflake or DuckDB, OAuth/JWT, OpenTelemetry.

Showcase: least-privilege design, prompt-injection defenses (tool outputs treated as untrusted data), input validation, a threat model in the README.

Resume bullet:

Designed an MCP server exposing governed, read-only financial-data tools to LLM agents, with JWT auth, per-tool authorization, query-cost limits, and audit logging; documented a threat model covering prompt injection and data exfiltration.

Project 3: Agent Evaluation and Observability Harness

Problem: Most agent demos have no way to measure quality or catch regressions. This is the biggest differentiator for Senior/Staff candidates.

How it works:

A framework that runs agents against a versioned test set (golden Q&A, expected tool calls, expected citations).
Metrics: task success, tool-call accuracy, groundedness/citation correctness, latency, cost per task.
LLM-as-judge scoring, with a small human-labeled subset to validate the judge.
CI integration (GitHub Actions) that fails a PR if quality drops beyond a threshold.
Tracing dashboard (OpenTelemetry + Grafana, which you already know).

Stack: Python or Java, GitHub Actions, OpenTelemetry, Grafana, plus the agents from Projects 1 and 2 as test subjects.

Resume bullet:

Built an evaluation and observability harness for LLM agents that tracks task success, tool-call accuracy, groundedness, latency, and cost per task; integrated into CI to block regressions, and used it to improve [metric] from [A] to [B] across [N] prompt/model iterations.

Suggested build order
Project 2 (MCP server): smallest, quickest to ship, and the others can reuse it.
Project 1 (triage agents): uses the MCP server as its tool layer.
Project 3 (eval harness): evaluates Projects 1 and 2, giving you real before/after numbers.

Together they tell a coherent story: governed tools, agents that use them, and measurement that proves they work.

How to present them on the resume

Put them in a short “Agentic AI Projects (open source)” section with the GitHub link beside each, 1-2 lines per project. Then link Doc AI to this story in your Morgan Stanley bullets: “extended RAG into agentic workflows with tool use and evaluation.”

README checklist (this is what gets read)
Architecture diagram and a “why these design choices” section
A limitations and failure modes section (reviewers love this)
Eval results table with real numbers
One-command setup (docker compose up)
A short demo GIF

One caution: don’t add the bullets to your resume until the repos exist and the numbers are real. Interviewers will open the repo and ask about trade-offs.

Tell me which one you’d like to start with, and I can draft the architecture, repo structure, and a week-by-week build plan.
