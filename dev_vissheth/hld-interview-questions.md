# HLD (System Design) Interview Questions — Complete Reference

> Covers all system design problems, core concepts, component breakdowns, and company-wise questions.

---

## Table of Contents

1. [Core HLD Building Blocks](#1-core-hld-building-blocks)
2. [HLD Problems by Category](#2-hld-problems-by-category)
   - [URL & Link Services](#21-url--link-services)
   - [Social Media & Feeds](#22-social-media--feeds)
   - [Messaging & Communication](#23-messaging--communication)
   - [Video & Media Streaming](#24-video--media-streaming)
   - [Search & Discovery](#25-search--discovery)
   - [Ride & Delivery](#26-ride--delivery)
   - [E-Commerce & Payments](#27-e-commerce--payments)
   - [Storage & File Systems](#28-storage--file-systems)
   - [Infrastructure & DevOps](#29-infrastructure--devops)
   - [Analytics & Monitoring](#210-analytics--monitoring)
   - [Gaming & Real-time](#211-gaming--real-time)
   - [Maps & Location](#212-maps--location)
   - [Collaboration Tools](#213-collaboration-tools)
   - [Booking & Reservation](#214-booking--reservation)
   - [Health, Finance & Misc](#215-health-finance--misc)
3. [Key Concepts Deep Dive](#3-key-concepts-deep-dive)
4. [Company-wise Questions](#4-company-wise-questions)
5. [Trade-off Decision Framework](#5-trade-off-decision-framework)

---

## 1. Core HLD Building Blocks

> Must-know components before designing any system.

### 1.1 Scalability

| Concept | Description | When to Use |
|---------|-------------|-------------|
| **Vertical Scaling** | Upgrade single machine (more CPU/RAM) | Simple, early stage, stateful apps |
| **Horizontal Scaling** | Add more machines behind load balancer | Stateless services, high traffic |
| **Auto-Scaling** | Dynamically add/remove instances based on load | Cloud-native, variable traffic |
| **Sharding** | Split database across multiple nodes by key | DB bottleneck, write-heavy |
| **Read Replicas** | Copy of DB for reads | Read-heavy workloads |

---

### 1.2 Load Balancing

| Type | Algorithm | Best For |
|------|-----------|---------|
| **Round Robin** | Rotate sequentially | Stateless, equal capacity servers |
| **Weighted Round Robin** | Weight by server capacity | Heterogeneous servers |
| **Least Connections** | Route to server with fewest active connections | Long-lived connections |
| **IP Hash** | Hash client IP → same server | Session stickiness |
| **Consistent Hashing** | Virtual nodes on ring | Cache clusters, distributed KV stores |
| **L4 Load Balancer** | Transport layer (TCP/UDP) | High throughput, low latency |
| **L7 Load Balancer** | Application layer (HTTP headers, URL) | Content-based routing, A/B testing |

---

### 1.3 Caching

| Strategy | How It Works | Pro | Con |
|----------|-------------|-----|-----|
| **Cache-Aside (Lazy)** | App checks cache; on miss reads DB + populates cache | Simple, resilient | Cache-miss latency, stale data |
| **Write-Through** | Write to cache + DB simultaneously | Always consistent | Higher write latency |
| **Write-Back (Write-Behind)** | Write to cache; async flush to DB | Fast writes | Data loss risk on crash |
| **Read-Through** | Cache sits in front; fetches from DB on miss | Transparent to app | Cold start latency |
| **Refresh-Ahead** | Pre-populate cache before expiry | Low latency on hot keys | Wasted resources if mispredict |

**Cache Eviction:** LRU (most common) · LFU · FIFO · Random · TTL-based

**Tools:** Redis · Memcached · Varnish · Nginx proxy cache · CDN edge cache

---

### 1.4 Databases

#### SQL vs NoSQL Decision

| Factor | SQL (PostgreSQL/MySQL) | NoSQL |
|--------|----------------------|-------|
| Schema | Fixed, structured | Flexible |
| Relationships | Joins, FK constraints | Denormalized |
| ACID | Full | Partial (depends on DB) |
| Scale | Vertical (+ read replicas + sharding) | Horizontal natively |
| Use when | Financial data, complex queries | Scale, flexibility, fast reads |

#### NoSQL Types

| Type | DB | Best For |
|------|----|---------|
| **Document** | MongoDB, Firestore | User profiles, catalogs, flexible schema |
| **Key-Value** | Redis, DynamoDB, Riak | Sessions, caching, leaderboards |
| **Wide-Column** | Cassandra, HBase, Bigtable | Time-series, write-heavy, IoT |
| **Graph** | Neo4j, Amazon Neptune | Social graphs, recommendations |
| **Search** | Elasticsearch, Solr | Full-text search, analytics |
| **Time-Series** | InfluxDB, TimescaleDB | Metrics, logs, IoT sensor data |

#### Sharding Strategies

| Strategy | How | Pro | Con |
|----------|-----|-----|-----|
| **Range-based** | Shard by range of key | Simple range queries | Hot spots |
| **Hash-based** | Hash(key) % N | Uniform distribution | Range queries hard |
| **Directory-based** | Lookup table of key→shard | Flexible | Lookup overhead |
| **Geo-based** | Shard by geography | Low latency for region | Skewed if unequal |

---

### 1.5 Consistency & CAP Theorem

```
CAP Theorem: Any distributed system can guarantee at most 2 of:
  C — Consistency (all nodes see same data at same time)
  A — Availability (every request gets a response)
  P — Partition Tolerance (system continues during network splits)

Since P is almost always required in distributed systems:
  CP systems: Zookeeper, HBase, MongoDB (strong consistency, may reject writes)
  AP systems: Cassandra, DynamoDB, CouchDB (always available, eventual consistency)
```

| Model | Description | Example Systems |
|-------|-------------|----------------|
| **Strong Consistency** | Read always returns latest write | PostgreSQL, Zookeeper |
| **Eventual Consistency** | System converges to consistent state eventually | Cassandra, DynamoDB |
| **Read-Your-Writes** | User always sees their own updates | Social media profile |
| **Causal Consistency** | Causally related writes seen in order | Chat messages |
| **Monotonic Read** | Never see older version after seeing newer | Shopping cart |

---

### 1.6 Message Queues & Event Streaming

| Tool | Type | Best For |
|------|------|---------|
| **Kafka** | Log-based, partitioned | High-throughput streaming, event sourcing, exactly-once |
| **RabbitMQ** | Message broker (AMQP) | Task queues, reliable delivery, routing |
| **AWS SQS** | Managed queue | Decoupling microservices, async tasks |
| **AWS SNS** | Pub-Sub | Fan-out notifications |
| **Google Pub/Sub** | Managed pub-sub | GCP streaming |
| **Redis Pub/Sub** | In-memory pub-sub | Real-time, fire-and-forget |

**Patterns:**
- **At-most-once:** Fire and forget (logs)
- **At-least-once:** Retry on failure (payments — needs idempotency)
- **Exactly-once:** Idempotent consumer + deduplication (financial transactions)

---

### 1.7 API Design

| Type | Protocol | Best For |
|------|----------|---------|
| **REST** | HTTP/JSON | Public APIs, CRUD operations, broad compatibility |
| **GraphQL** | HTTP/JSON | Flexible queries, avoid over/under-fetching, mobile |
| **gRPC** | HTTP/2 + Protobuf | Internal microservices, low latency, streaming |
| **WebSocket** | Full-duplex TCP | Real-time: chat, live scores, stock prices |
| **Server-Sent Events (SSE)** | HTTP, server→client only | Notifications, live feed |
| **Long Polling** | HTTP repeated requests | Fallback for WebSocket |

---

### 1.8 Microservices Patterns

| Pattern | Problem It Solves | Description |
|---------|------------------|-------------|
| **API Gateway** | Single entry point | Auth, rate limiting, routing, SSL termination |
| **Service Discovery** | Find service instances | Consul, Eureka, Kubernetes DNS |
| **Circuit Breaker** | Prevent cascade failures | Stop calling failing service (Hystrix, Resilience4j) |
| **Saga Pattern** | Distributed transactions | Chain of local transactions with compensating rollbacks |
| **CQRS** | Read/write scale separately | Separate read model from write model |
| **Event Sourcing** | Audit trail, replay | Store events not state; derive state by replaying |
| **Sidecar** | Cross-cutting concerns | Logging, auth, tracing as separate process per service |
| **Strangler Fig** | Migrate monolith | Gradually replace monolith with microservices |
| **BFF** | Per-client API | Backend For Frontend (mobile vs web vs third-party) |

---

### 1.9 CDN (Content Delivery Network)

- **Push CDN:** You upload content → CDN caches it everywhere
- **Pull CDN:** CDN fetches from origin on first request, caches thereafter
- **Edge Caching:** Static assets (JS/CSS/images), videos
- **Dynamic CDN:** Route to nearest PoP, still fetch from origin

**Tools:** Cloudflare · AWS CloudFront · Akamai · Fastly

---

### 1.10 Networking & Protocols

| Component | Role |
|-----------|------|
| **DNS** | Domain → IP resolution (A, CNAME, MX records) |
| **TCP** | Reliable ordered delivery; 3-way handshake |
| **UDP** | Fast, no guarantee; video/audio streaming, DNS |
| **HTTP/1.1** | One request per connection (keep-alive) |
| **HTTP/2** | Multiplexing, header compression, server push |
| **HTTP/3 / QUIC** | UDP-based, 0-RTT, better mobile |
| **TLS/SSL** | Encryption; mutual TLS for microservices |
| **WebSocket** | Persistent full-duplex; real-time apps |

---

### 1.11 Reliability Concepts

| Concept | Description |
|---------|-------------|
| **RPO** (Recovery Point Objective) | How much data loss is acceptable |
| **RTO** (Recovery Time Objective) | How fast to recover from failure |
| **SLA** | Service Level Agreement (e.g., 99.99% uptime) |
| **SLO** | Service Level Objective (internal target) |
| **SLI** | Service Level Indicator (metric measured) |
| **MTTR** | Mean Time To Recover |
| **MTBF** | Mean Time Between Failures |
| **Idempotency** | Same request = same result (no duplicates) |
| **Heartbeat** | Periodic signal to detect failures |
| **Checksum** | Data integrity verification |
| **Replication** | Sync / Async replica for failover |
| **Failover** | Automatic switch to replica on primary failure |

---

### 1.12 Numbers Every SDE Must Know

```
Latency Reference:
  L1 cache        ~1 ns
  L2 cache        ~10 ns
  RAM access      ~100 ns
  SSD read        ~100 µs
  HDD seek        ~10 ms
  Network (same DC)   ~0.5 ms
  Network (cross DC)  ~100 ms
  Network (worldwide) ~150-300 ms

Storage:
  1 KB = 10^3 bytes
  1 MB = 10^6 bytes
  1 GB = 10^9 bytes
  1 TB = 10^12 bytes
  1 PB = 10^15 bytes

Traffic estimates (rough):
  Twitter: ~400M tweets/day = ~4600 tweets/sec
  YouTube: ~500 hours video uploaded per minute
  Facebook: ~2B daily active users
  WhatsApp: ~100B messages/day

Data sizes:
  UUID: 36 bytes
  Tweet text: ~300 bytes
  User metadata: ~1 KB
  Photo (compressed): ~200 KB - 1 MB
  Video (1 min HD): ~50 MB
```

---

## 2. HLD Problems by Category

---

### 2.1 URL & Link Services

#### Design URL Shortener (TinyURL / Bitly)
**Companies:** Google, Amazon, Twitter, Facebook, Microsoft

**Functional Requirements:**
- Given long URL → generate short URL (e.g., tinyurl.com/abc123)
- Redirect short URL → original long URL
- Custom aliases (optional)
- Analytics (click count, geo, referrer)
- Expiry support

**Non-Functional Requirements:**
- 100M URLs created/day = ~1200 writes/sec
- 10B redirects/day = ~115K reads/sec (read-heavy, 10:1 ratio)
- Low latency redirect (~10ms)
- High availability (99.99%)
- URLs must be unique

**Key Design Decisions:**

| Decision | Option A | Option B | Choice |
|----------|----------|----------|--------|
| Short code generation | MD5 hash (first 7 chars) | Base62 counter + encode | Base62 counter (no collision) |
| Collision handling | Check DB on each insert | Pre-generate pool | Pre-generate pool |
| Storage | SQL (PostgreSQL) | NoSQL (DynamoDB) | NoSQL (simple KV, scale) |
| Caching | None | Redis (hot URLs) | Redis with LRU |

**Architecture:**
```
Client
  → DNS
  → Load Balancer (L7)
  → API Servers (stateless, horizontal)
      → URL Generation Service
          → ID Generator (distributed, e.g., Snowflake)
          → Base62 Encoder
      → Redirect Service
          → Redis Cache (TTL = 24h for hot URLs)
          → NoSQL DB (DynamoDB) — {shortCode: longURL, expiry, createdBy}
      → Analytics Service (async)
          → Kafka → Stream Processor → Analytics DB (Cassandra)
```

**DB Schema:**
```
urls table: short_code (PK), long_url, user_id, created_at, expires_at, click_count
users table: user_id, email, plan
custom_alias table: alias (PK) → short_code
```

**Trade-offs:**
- Pre-generation vs on-demand: Pre-gen avoids latency but needs coordination
- 301 (permanent) vs 302 (temporary) redirect: 302 keeps analytics working
- SQL vs NoSQL: NoSQL for scale, SQL if analytics joins needed

---

#### Design Pastebin
**Companies:** Google, Amazon

**Requirements:** Store and share text (code snippets, notes) with expiry

**Architecture:**
```
Client → LB → App Server
  → Object Storage (S3) for content
  → DB (short_key → S3_path, metadata)
  → Cache (Redis) for hot pastes
```

---

### 2.2 Social Media & Feeds

#### Design Twitter / X
**Companies:** Twitter, Facebook, Google, Uber

**Functional Requirements:**
- Post tweets (text, images, video, polls)
- Follow/unfollow users
- News Feed (personalized, chronological)
- Like, Retweet, Reply, Quote Tweet
- Hashtags, trending topics
- Notifications
- Search

**Non-Functional Requirements:**
- 400M tweets/day = ~4600 writes/sec
- 200M DAU, each reads feed ~10 times = 2B reads/day = ~23K reads/sec
- Celebrity accounts: 100M followers (fanout problem)
- Feed load latency < 200ms

**Key Design Decision — Feed Generation:**

| Strategy | How | Pro | Con |
|----------|-----|-----|-----|
| **Fanout on Write (Push)** | On tweet → push to all followers' feed cache | Fast read | Slow write for celebs (100M ops) |
| **Fanout on Read (Pull)** | On feed request → pull tweets from followees | Simple writes | Slow read, complex aggregation |
| **Hybrid** | Push for regular users, pull for celebs (>1M followers) | Best of both | Complex logic |

**Twitter uses Hybrid approach.**

**Architecture:**
```
Client
  → API Gateway (Auth, Rate Limit, SSL)
  → Load Balancer
  ├── Tweet Service → Kafka (tweet events)
  │     └── DB: Cassandra (tweet_id, user_id, content, created_at)
  │     └── Media: S3 + CDN for images/video
  ├── Feed Service
  │     → Redis (user_id → [tweet_id list]) — pre-computed feed
  │     → Feed Generation Worker (Kafka consumer)
  ├── User Service → DB: PostgreSQL (user metadata)
  ├── Follow Service → Graph DB or Cassandra (follower/following tables)
  ├── Search Service → Elasticsearch (tweet full-text index)
  ├── Trending Service
  │     → Count hashtags in sliding window → Redis sorted set
  └── Notification Service → Push (FCM/APNs), Email, SMS
```

**DB Design:**
```
tweets: tweet_id (Snowflake), user_id, content, media_urls[], created_at, reply_to, retweet_of
users: user_id, username, email, bio, follower_count, following_count
follows: follower_id, followee_id, created_at  [Cassandra, partition by follower_id]
user_feed: user_id, tweet_id, score  [Redis Sorted Set]
likes: tweet_id, user_id  [Cassandra]
```

---

#### Design Instagram
**Companies:** Facebook/Meta, Google

**Functional Requirements:**
- Upload photos/videos with captions
- Follow users, Feed of followed accounts
- Like, Comment, Story (24h expiry)
- Explore / Discover (recommendations)
- Direct Messages
- Reels (short video)

**Key Challenges:**
- Media storage and delivery at scale (CDN)
- Feed generation for 2B users
- Real-time story views

**Architecture:**
```
Client
  → CDN (images/videos — pull model)
  → API Gateway
  ├── Media Upload Service → S3 (original) → Transcoding Pipeline → CDN
  ├── Post Service → Cassandra (posts) + Elasticsearch (search)
  ├── Feed Service (Hybrid fanout — same as Twitter)
  │     → Redis (pre-computed feeds)
  ├── Story Service → Redis (TTL 24h) + S3
  ├── Recommendation Service → ML model (collaborative filtering)
  └── Messaging Service (DM) → same as WhatsApp mini design
```

---

#### Design Facebook News Feed
**Companies:** Facebook/Meta

**Functional Requirements:**
- Fetch feed of posts from friends + pages
- Rank by relevance (EdgeRank / ML model)
- Posts: text, image, video, links, events, polls

**Key Design:**
- **Aggregation:** Collect posts from all friends
- **Ranking:** Score by affinity × weight × time decay
- **Truncation:** Show top-K scored posts
- **Pagination:** Cursor-based (avoid offset for large feeds)

**Architecture:**
```
Feed Aggregator
  → Fetch post IDs from friend list (Graph DB: TAO at Facebook)
  → Fetch post metadata from Object Store
  → Score via Ranking Service (ML models)
  → Cache ranked feed in Redis
  → Serve paginated feed to client
```

---

#### Design LinkedIn
**Companies:** LinkedIn, Microsoft

**Functional Requirements:**
- Professional profiles (experience, education, skills)
- Connections (1st, 2nd, 3rd degree)
- Job search + applications
- Feed (posts, shared articles)
- Endorsements, Recommendations
- "People You May Know"

**Architecture:**
```
├── Profile Service → PostgreSQL (structured) + Elasticsearch (search)
├── Graph Service → Graph DB (connections) → BFS for degrees
│     → "People You May Know" via common connections (Spark batch job)
├── Job Service → Elasticsearch (job search, filters)
├── Feed Service → Same feed pattern as Twitter
├── Recommendation Service → ML (collaborative filtering on graph)
└── Search Service → Elasticsearch + Typeahead
```

---

#### Design TikTok / Short Video Platform
**Companies:** TikTok, Instagram Reels, YouTube Shorts, Snapchat

**Functional Requirements:**
- Upload, process, serve short videos (15s–3min)
- For You Page (FYP) — personalized infinite scroll
- Like, comment, share, duet
- Creator monetization

**Key Challenges:**
- Video transcoding pipeline (multiple resolutions/formats)
- Cold start problem for new users (no history)
- Near-realtime recommendation updates

**Architecture:**
```
Video Upload Pipeline:
Client → Upload Service → S3 (raw) → Kafka
  → Transcoding Workers (FFmpeg) → multiple formats (360p, 720p, 1080p)
  → CDN (store processed video)
  → Metadata DB (video_id, creator_id, tags, duration)

Recommendation (FYP):
  Online: real-time signals (views, likes, watch time) → Feature Store → Model serving
  Offline: batch training (Spark) → periodic model updates
  → Candidate Generation → Scoring → Filtering → Feed
```

---

### 2.3 Messaging & Communication

#### Design WhatsApp / Messenger
**Companies:** WhatsApp/Meta, Telegram, Slack, Microsoft Teams

**Functional Requirements:**
- 1-on-1 messaging
- Group chats (up to 256 members)
- Message delivery status: Sent ✓ → Delivered ✓✓ → Read ✓✓ (blue)
- Media sharing (images, videos, docs, voice notes)
- End-to-end encryption (conceptual)
- Last seen / online status

**Non-Functional Requirements:**
- 100B messages/day = ~1.15M messages/sec
- < 100ms delivery latency
- Store messages until delivered (not after, in WhatsApp)
- High availability

**Key Design — Message Flow:**
```
Sender → WebSocket connection to Chat Server
  → Chat Server checks recipient's connection server (using User Session Service)
  → If online: forward directly via recipient's Chat Server
  → If offline: store in Message Queue (Kafka) → push notification
  → Recipient receives → ACK → Update delivery status
  → Status propagated back to Sender
```

**Architecture:**
```
Client (Mobile/Web)
  → WebSocket (persistent connection) → Chat Server pool
      → Message Router (Redis pub/sub or consistent hash)
          → Message DB: Cassandra (message_id, chat_id, sender_id, content, timestamp, status)
          → Offline Queue: Kafka / Message Store
  → Media Service → S3 + CDN
  → User Service → Redis (session: user_id → chat_server_id)
  → Notification Service → APNS / FCM (for offline users)
  → Group Service → Cassandra (group_id, member_list)
```

**DB Design:**
```
messages: message_id (Snowflake PK), chat_id, sender_id, content_type, content, timestamp, status
chats: chat_id, chat_type (DIRECT/GROUP), created_at
chat_members: chat_id, user_id, joined_at, last_read_at
users: user_id, phone, name, avatar, last_seen
```

---

#### Design Slack
**Companies:** Slack, Microsoft (Teams)

**Functional Requirements:**
- Workspaces → Channels → Messages
- DMs, thread replies
- Search messages
- File sharing, integrations/bots
- Real-time delivery

**Key Differences from WhatsApp:**
- Channel-based vs contact-based
- Message history is permanent
- Rich bots/integrations (webhook, slash commands)
- Full-text search critical

**Architecture:**
```
├── Real-time Layer: WebSocket → Channel Server → Fan-out to all channel members
├── Message DB: Cassandra (channel_id, timestamp, message)
├── Search: Elasticsearch (full-text message index)
├── File Service: S3 + CDN
├── Bot/Integration Service: Webhook handler, OAuth
└── Presence Service: Redis (user_id → status, last_seen)
```

---

#### Design Zoom / Video Conferencing
**Companies:** Zoom, Microsoft Teams, Google Meet, Cisco Webex

**Functional Requirements:**
- 1-on-1 and group video calls (up to 1000+ participants)
- Screen sharing
- Chat during meeting
- Recording
- Waiting room, breakout rooms

**Key Challenges:**
- Real-time media (audio/video) with sub-100ms latency
- P2P vs Media Server: P2P works for small groups; for large → SFU/MCU

**Protocols:**
- **WebRTC:** Browser-native real-time media (P2P with STUN/TURN)
- **SFU (Selective Forwarding Unit):** Each client sends one stream; SFU selectively forwards → scales better
- **MCU (Multipoint Control Unit):** Mix all streams into one → less bandwidth on client, high server cost

**Architecture:**
```
Client (WebRTC)
  → Signaling Server (WebSocket) → exchange SDP + ICE candidates
  → STUN/TURN Server (NAT traversal)
  → SFU Media Server → forward selected video/audio streams
  → Recording Service → S3 (async transcription)
  → Chat Service (text during meeting)
  → Meeting DB: PostgreSQL (meeting_id, host, participants[], status)
```

---

#### Design Email System (Gmail)
**Companies:** Google, Microsoft

**Functional Requirements:**
- Send, receive, reply, forward emails
- Labels, folders, filters
- Search (full-text)
- Attachments
- Spam filtering

**Architecture:**
```
├── SMTP Gateway (inbound/outbound email)
├── Email Storage: Blob (message content in S3), DB (metadata in Bigtable/Cassandra)
├── Search: Elasticsearch
├── Spam Filter: ML model (Bayesian + deep learning)
├── Push Notification (new mail alert)
└── Attachment Service: S3 + virus scan
```

---

#### Design Notification System
**Companies:** Facebook, Google, Amazon, Uber, all consumer apps

**Functional Requirements:**
- Channels: Push (mobile), Email, SMS, In-App
- Notification types: transactional, marketing, system alert
- Priority (critical vs promotional)
- User preference management (opt-out, quiet hours)
- Rate limiting (don't spam)
- Retry + dead-letter queue

**Architecture:**
```
Event Sources (Order Service, Payment Service, etc.)
  → Kafka (notification events)
  → Notification Service
      → Preference Service (check user settings)
      → Template Service (populate template with data)
      → Priority Queue (High / Normal / Low)
      → Channel Workers:
          ├── Push Worker → FCM (Android) / APNs (iOS)
          ├── Email Worker → SendGrid / SES
          ├── SMS Worker → Twilio / SNS
          └── In-App Worker → WebSocket / polling
      → Retry Service (exponential backoff)
      → Analytics DB (delivery, open, click tracking)
```

---

### 2.4 Video & Media Streaming

#### Design Netflix / YouTube Video Streaming
**Companies:** Netflix, YouTube, Amazon Prime, Hotstar, Twitch

**Functional Requirements:**
- Upload, transcode, store videos
- Stream to millions concurrently (adaptive bitrate)
- Recommendations
- Search
- Watchlist, Continue Watching
- Subtitles, multiple audio tracks

**Non-Functional Requirements:**
- YouTube: 500 hours video/minute uploaded
- Netflix: 15% of global internet bandwidth
- < 2 sec startup latency
- No rebuffering (adaptive bitrate streaming)

**Video Upload & Processing Pipeline:**
```
Creator uploads raw video
  → Upload Service → S3 (raw, chunked multipart upload)
  → Kafka event: video_uploaded
  → Transcoding Workers (FFmpeg) — parallel per resolution
      → 360p, 480p, 720p, 1080p, 4K
      → Multiple codecs (H.264, H.265/HEVC, AV1)
      → Generate thumbnails
      → Extract metadata
  → Processed video → CDN (CloudFront/Akamai)
  → Update Video DB: AVAILABLE status
  → Content Moderation (ML) → human review if flagged
```

**Streaming Architecture:**
```
Client (player)
  → CDN PoP (nearest) → cache hit? → stream chunks (HLS/DASH segments)
  → Cache miss → Origin (S3)
  → ABR (Adaptive Bitrate): player switches quality based on network speed
  → Video chunks: each segment ~2–10 seconds
```

**Recommendations:**
```
Offline (batch): Spark + ML (collaborative filtering on watch history)
Online (real-time): Session-based signals → re-rank
A/B testing: Test different recommendation models
```

**Full Architecture:**
```
├── Upload Service → S3 + Kafka
├── Transcoding Service (workers, horizontally scaled)
├── CDN (video delivery)
├── Video Metadata DB: Cassandra (video_id, creator_id, title, tags, status)
├── Search: Elasticsearch
├── User Service: PostgreSQL
├── Watch History Service: Cassandra (user_id, video_id, progress, timestamp)
├── Recommendation Service: ML model + Feature Store
├── Subscription/Billing: Stripe integration
└── Analytics: Kafka → Flink/Spark → Data Warehouse
```

---

#### Design YouTube Live / Twitch (Live Streaming)
**Companies:** YouTube, Twitch, Facebook Live, Instagram Live

**Key Differences from VOD:**
- Ultra-low latency (< 3 seconds for live, < 100ms for gaming)
- No pre-transcoding (done in real-time)
- DVR buffer (go back 30s)

**Architecture:**
```
Broadcaster (OBS/mobile)
  → RTMP ingest server (closest edge)
  → Transcoding in real-time (per resolution)
  → HLS/DASH manifest → CDN edge → Viewers

Chat: WebSocket → Redis Pub/Sub → fan-out to viewers
Moderation: ML (hate speech detection, real-time)
```

---

#### Design Spotify / Music Streaming
**Companies:** Spotify, Apple Music, Amazon Music

**Functional Requirements:**
- Stream songs, albums, playlists, podcasts
- Offline download
- Social (friend activity, collaborative playlists)
- Recommendations (Discover Weekly, Daily Mix)
- Lyrics sync

**Architecture:**
```
├── Audio Storage: S3 (multiple bitrates: 96/160/320 kbps)
├── CDN: Songs cached at edge (top 10% songs = 90% streams)
├── Metadata DB: PostgreSQL (song, album, artist)
├── Playlist Service: Cassandra (user_id → playlist → song_ids)
├── Stream Service: Signed URL from CDN (DRM protected)
├── Recommendation: Spark ML (collaborative filtering + audio features)
├── Download Service: Encrypted local cache
└── Analytics: Kafka → Flink (play counts, skip rates)
```

---

### 2.5 Search & Discovery

#### Design Google Search (Web Crawler + Search Engine)
**Companies:** Google, Bing, Amazon

**Functional Requirements:**
- Crawl web pages
- Index content
- Rank results (PageRank + ML)
- Return results in < 200ms

**Architecture:**
```
Web Crawler:
  Seed URLs → URL Frontier (priority queue)
  → DNS Resolver + Fetcher (politeness: robots.txt, crawl delay)
  → Content Parser (HTML → text, extract links)
  → Duplicate Detector (Bloom Filter / SimHash for near-duplicate)
  → URL Frontier (newly discovered URLs)
  → Content Store: S3 (raw HTML)

Indexer:
  Raw HTML → Parser → Tokenizer → Stemmer/Lemmatizer
  → Inverted Index: {word → [(doc_id, position, frequency)]}
  → Stored in distributed KV (Bigtable)

Query Processing:
  Query → Tokenize → Expand (synonyms) → Lookup inverted index
  → Candidate docs → PageRank score × TF-IDF × ML signals
  → Top-K results → Snippet generation → Return
```

---

#### Design Search Autocomplete / Typeahead
**Companies:** Google, Amazon, Twitter, LinkedIn, Uber
*(LeetCode 642)*

**Functional Requirements:**
- As user types → suggest completions in < 100ms
- Rank by frequency/popularity
- Personalized suggestions
- Recent searches

**Architecture:**
```
Client (debounced input)
  → API Gateway
  → Autocomplete Service
      → Cache (Redis): prefix → [top-K suggestions] (TTL short)
      → Trie Service (in-memory Trie for prefix lookup)
      → Offline aggregation: Hadoop → compute top-K per prefix daily
      → Personalization: blend global + personal history

Update pipeline:
  Search logs → Kafka → Spark (aggregate frequencies) → rebuild Trie
```

---

#### Design Elasticsearch / Full-Text Search
**Companies:** Elastic, all companies with search features

**Key Concepts:**
- Inverted index: term → document list
- Sharding: split index across nodes
- Replication: replica shards for availability
- Query types: match, phrase, fuzzy, range, bool, nested

---

### 2.6 Ride & Delivery

#### Design Uber / Lyft
**Companies:** Uber, Lyft, Ola, Didi, Grab

**Functional Requirements:**
- Request ride (pickup + drop)
- Real-time driver location tracking
- Driver matching (nearest available)
- Surge pricing
- Trip status updates
- Payment + rating

**Non-Functional Requirements:**
- Driver sends location every 3-4 seconds
- 10M drivers → ~2.5M location updates/sec
- Match latency < 2 seconds
- High availability (99.99%)

**Architecture:**
```
Driver App
  → Location Service (WebSocket) → Redis (driver_id → {lat, lng, status})
                                 → Geo-index (QuadTree / S2 / H3 cells)

Rider App → Ride Request
  → Matching Service
      → Geospatial query: find drivers within radius
      → Rank by: distance × ETA × rating
      → Send offer to top-K drivers (first accept wins)
  → Trip Service → DB: PostgreSQL (trip_id, rider, driver, status, route)
  → Surge Pricing Service
      → Supply (available drivers) vs Demand (requests) per geo cell
      → Real-time calculation → update multiplier

Realtime Updates:
  → Kafka (trip events) → Notification Service → Rider/Driver apps
  → Route updates via Google Maps API
```

**Geo-Indexing Options:**

| Method | Description | Used By |
|--------|-------------|---------|
| **QuadTree** | Divide space into quadrants recursively | Game, early GPS |
| **Geohash** | Encode lat/lng as alphanumeric string | Redis GEOADD, many apps |
| **S2 Library** | Sphere cells (Google) | Google Maps, Uber |
| **H3 (Hexagonal Grid)** | Uber's hexagonal geospatial index | Uber (now open-source) |

---

#### Design Food Delivery (DoorDash / Uber Eats / Swiggy)
**Companies:** DoorDash, Uber Eats, Swiggy, Zomato, Grab Food

**Functional Requirements:**
- Browse restaurants by location
- Place order, real-time tracking
- Assign delivery partner (nearest available)
- ETA calculation
- Payment + rating

**Architecture:**
```
├── Restaurant Service: restaurant metadata, menu, availability
├── Order Service: Kafka (order events) → state machine
│     OrderStatus: PLACED → ACCEPTED → PREPARING → READY → PICKED_UP → DELIVERED
├── Dispatch Service: same as Uber driver matching but for delivery partners
├── Location Service: real-time delivery partner location (WebSocket → Redis + H3)
├── ETA Service: Google Maps API + ML model
├── Payment Service: Stripe/payment gateway
└── Notification Service: real-time status to customer
```

---

### 2.7 E-Commerce & Payments

#### Design Amazon / E-Commerce Platform
**Companies:** Amazon, Flipkart, Walmart, Alibaba, eBay

**Functional Requirements:**
- Product catalog (search, filter, browse)
- Cart → Checkout → Order → Shipment
- Inventory management
- Reviews + ratings
- Recommendations
- Flash sales

**Architecture:**
```
├── Product Service → Elasticsearch (search) + DynamoDB (product data) + S3 (images/CDN)
├── Inventory Service → Redis (real-time stock) + PostgreSQL (source of truth)
│     → Kafka (inventory events: reservations, releases)
├── Cart Service → Redis (cart: user_id → items[]) → volatile, session-like
├── Order Service → PostgreSQL + Kafka (order events)
│     → State: PLACED → PAYMENT_PENDING → CONFIRMED → WAREHOUSE → SHIPPED → DELIVERED
├── Payment Service → Stripe/Razorpay + idempotency keys
├── Shipping Service → carrier API integration + tracking
├── Recommendation Service → ML (collaborative filtering)
├── Review Service → PostgreSQL (reviews) + fraud detection
└── Search: Elasticsearch (with filters: price, rating, brand, category)
```

**Flash Sale Design:**
```
Pre-sale:
  → Product listed, countdown timer
  → Pre-load inventory to Redis

At sale start:
  → Rate limiter (token bucket per user)
  → Redis atomic DECR (inventory) — single operation, no race conditions
  → Reserve in Redis → async confirm in DB
  → Queue overflow → virtual waiting room (Kafka + WebSocket)
```

---

#### Design Payment System (Stripe / Razorpay)
**Companies:** Stripe, Razorpay, PayPal, Square, Visa, Mastercard

**Functional Requirements:**
- Accept payments (credit/debit, UPI, wallets)
- Process refunds, disputes
- Payouts to merchants
- Webhooks for event notification
- Fraud detection

**Key Challenges:**
- **Idempotency:** Same payment request → process only once (idempotency key)
- **ACID transactions:** Money must not be lost or duplicated
- **Reconciliation:** Match payments with bank records

**Architecture:**
```
Client → API Gateway (TLS 1.3)
  → Payment Service
      → Idempotency Check (Redis: idempotency_key → result)
      → Risk/Fraud Check (ML model, velocity checks)
      → Payment Processor (Stripe/bank API)
      → DB: PostgreSQL (ledger — append-only, double-entry bookkeeping)
      → Kafka: payment events → Analytics, Notification, Reconciliation
      → Webhook Service → retry with exponential backoff → merchant endpoints
```

---

#### Design Digital Wallet (Paytm / Google Pay)
**Companies:** PayTM, PhonePe, Google Pay, Apple Pay

**Functional Requirements:**
- Add money (bank/card top-up)
- P2P transfer
- Pay merchants (QR/UPI)
- Transaction history
- Cashback/rewards

**Key Challenges:**
- **Double spend prevention:** Distributed lock (Redis SETNX) or DB serializable transaction
- **Ledger consistency:** Immutable ledger, event sourcing

**Architecture:**
```
├── Account Service → Balance (PostgreSQL, serializable reads)
├── Transaction Service → Kafka (transaction events)
│     → Double-entry: debit sender + credit receiver atomically (DB transaction)
├── Payment Gateway → UPI / NEFT / bank API
├── Fraud Detection → ML (real-time scoring) + rules engine
└── Rewards Service → Cashback calculation
```

---

### 2.8 Storage & File Systems

#### Design Dropbox / Google Drive
**Companies:** Dropbox, Google Drive, OneDrive, Box

**Functional Requirements:**
- Upload, download, sync files across devices
- Folder hierarchy
- Sharing (view/edit/comment)
- Conflict resolution (multiple edits offline)
- Versioning
- Large files (up to 50 GB)

**Non-Functional Requirements:**
- 500M users, 100M DAU
- 50 million file sync events/day

**Key Design — Delta Sync (only upload changed blocks):**
```
File → split into chunks (4MB each)
Each chunk → hash (MD5/SHA256)
Compare chunk hashes with server → only upload changed chunks
Server stores chunks in S3 with deduplication (same hash = same chunk, share storage)
```

**Architecture:**
```
Client (Desktop/Mobile)
  → File Watcher → detect changes
  → Sync Engine → compute delta (chunk diff)
  → Upload changed chunks → Block Storage (S3)
  → Metadata update → Metadata Service
  → Notification via WebSocket/Long-Poll → other devices sync

Components:
├── Metadata Service → PostgreSQL (file_id, path, version, chunks[], user_id)
├── Block Storage: S3 (chunks, content-addressed by hash)
├── Sync Service: WebSocket → notify clients of changes
├── Conflict Resolution: "last write wins" or branching (like Git)
├── Sharing Service: ACL (access control lists) per file/folder
└── CDN: for frequently downloaded files
```

**DB Schema:**
```
files: file_id, name, path, owner_id, size, created_at, updated_at, is_dir
file_versions: version_id, file_id, version_num, chunk_ids[], created_at
chunks: chunk_id (hash), s3_path, size
shares: share_id, file_id, shared_with, permission (VIEW/EDIT)
```

---

#### Design Amazon S3 / Object Storage
**Companies:** Amazon, Google, Microsoft, Cloudflare (R2)

**Functional Requirements:**
- Store and retrieve arbitrary objects (files)
- Unlimited storage
- 99.999999999% (11 nines) durability
- Versioning, lifecycle policies, access control

**Architecture:**
```
├── API Service → S3 REST API (PUT/GET/DELETE)
├── Metadata Service → key → {location, size, checksum, version, ACL}
│     → Stored in distributed KV (DynamoDB-like)
├── Data Storage: Data Nodes (actual byte storage)
│     → Replication: 3 copies across AZs
│     → Erasure Coding for durability (cost-efficient for infrequent access)
├── Consistent Hashing → map object key → data node
├── Garbage Collection → delete unreferenced chunks
└── Lifecycle Manager → move to cold storage (Glacier) based on rules
```

---

#### Design Distributed File System (GFS / HDFS)
**Companies:** Google, Facebook, Netflix

**Architecture:**
```
Master Node (NameNode in HDFS):
  → Metadata: filename → list of chunk IDs + chunk server locations
  → In-memory for fast access (replicated to disk)

Chunk Servers (DataNodes):
  → Store actual 64MB chunks
  → Each chunk replicated 3× across servers
  → Heartbeat to Master

Client:
  → Ask Master for chunk locations
  → Read/write directly to Chunk Servers
  → Master never in data path (reduces bottleneck)
```

---

### 2.9 Infrastructure & DevOps

#### Design Rate Limiter
**Companies:** Twitter, Stripe, Cloudflare, GitHub, Uber

**Algorithms:**

| Algorithm | How | Pro | Con |
|-----------|-----|-----|-----|
| **Fixed Window Counter** | Count requests per window (e.g., 100/min) | Simple | Burst at window boundary |
| **Sliding Window Log** | Log every request timestamp; count in window | Accurate | High memory |
| **Sliding Window Counter** | Weighted combo of current + previous window | Accurate, memory-efficient | Approximate |
| **Token Bucket** | Tokens added at rate r; request consumes 1 token | Handles bursts | — |
| **Leaky Bucket** | Queue requests; process at fixed rate | Smooth output | Queue delay |

**Architecture:**
```
Client Request → API Gateway
  → Rate Limiter Middleware
      → Redis: INCR key + EXPIRE (atomic)
      → Key: user_id:endpoint:window_timestamp
      → If count > limit → 429 Too Many Requests
      → Header: X-RateLimit-Remaining, X-RateLimit-Reset
```

---

#### Design Distributed ID Generator (Snowflake)
**Companies:** Twitter, Instagram, Discord, all distributed systems

**Requirements:** Generate unique, sortable, ~unique-per-millisecond IDs at scale

**Snowflake ID (64-bit):**
```
[1 bit: sign] [41 bits: timestamp ms] [10 bits: machine ID] [12 bits: sequence]

41 bits timestamp → ~69 years of IDs
10 bits machine ID → 1024 machines
12 bits sequence → 4096 IDs/ms per machine

Total: 4096 × 1024 machines × 1000 ms = ~4B IDs/sec
```

**Alternatives:**
- UUID (128-bit, not sortable, no ordering)
- Database auto-increment (single point of failure)
- Redis INCR (single point, but can cluster)
- Ticket Server (Flickr's approach)

---

#### Design Distributed Cache (Redis / Memcached)
**Companies:** All companies

**Architecture:**
```
Client → Cache Client (consistent hashing to select node)
  → Cache Cluster (N nodes)
      → Each node: in-memory hash table
      → Replication: primary-replica per shard
      → Eviction: LRU / LFU / volatile-lru

Redis Cluster:
  → 16384 hash slots divided among nodes
  → Client redirected to correct slot (MOVED error)
  → Gossip protocol for cluster state

Cache Problems:
├── Cache Stampede: many requests hit DB simultaneously on cold cache
│     → Solution: mutex lock / probabilistic early expiry
├── Cache Penetration: query for non-existent key hits DB every time
│     → Solution: Bloom Filter to check existence before DB
└── Cache Avalanche: all cache expires at same time
      → Solution: stagger TTLs + random jitter
```

---

#### Design Distributed Message Queue (Kafka)
**Companies:** LinkedIn (built Kafka), Netflix, Uber, Confluent

**Architecture:**
```
Kafka Cluster:
├── Brokers (servers storing logs)
├── Topics (logical stream, split into partitions)
├── Partitions (ordered, immutable log; each on one broker)
├── Replication (each partition replicated to N brokers)
├── Consumer Groups (each group reads entire topic; partitions split among members)
└── Zookeeper / KRaft (cluster metadata, leader election)

Producer → choose partition (hash key or round-robin) → append to log
Consumer → track offset (position in log) → commit offset after processing
```

---

#### Design API Gateway
**Companies:** All, AWS (Kong, NGINX Plus, custom)

**Responsibilities:**
- SSL termination
- Authentication / Authorization (JWT, OAuth)
- Rate limiting
- Request routing (to microservices)
- Load balancing
- Response caching
- Request/response transformation
- Circuit breaker
- Logging + monitoring

---

#### Design CDN
**Companies:** Cloudflare, Akamai, Fastly, AWS CloudFront

**Architecture:**
```
Origin Server (S3 or App Server)
  → CDN PoPs (Points of Presence) globally
      → Cache static assets with TTL
      → Anycast routing: user → nearest PoP
      → Cache miss → fetch from origin + cache

Purge/Invalidation:
  → Tag-based invalidation
  → URL-based purge API
  → Surrogate-Control headers
```

---

#### Design Web Crawler
**Companies:** Google, Bing, Amazon, Common Crawl

**Architecture:**
```
Seed URLs
  → URL Frontier (priority queue: BFS / PageRank-weighted)
  → Scheduler (respect robots.txt, crawl delay, politeness)
  → Fetcher (HTTP GET → raw HTML)
  → DNS Cache (avoid repeated DNS lookups)
  → Content Parser → extract text + links
  → Dedup (Bloom Filter for URL; SimHash for near-duplicate content)
  → Storage: S3 (raw HTML) + Index DB (parsed content)
  → New URLs → back to URL Frontier
```

---

#### Design Task Scheduler / Cron Job System
**Companies:** All, Airflow, Celery users

**Requirements:**
- Schedule tasks (one-time or recurring cron)
- Distributed execution
- Retry on failure
- Task dependencies (DAG)
- Monitoring + alerting

**Architecture:**
```
├── Job Registry: PostgreSQL (job_id, schedule, type, dependencies, status)
├── Scheduler: poll DB for due jobs → push to Queue
│     → Use Redis sorted set: {job_id: next_run_timestamp}
├── Message Queue: Kafka / SQS
├── Workers: pick jobs from queue, execute, report status
├── Retry Service: exponential backoff → DLQ on final failure
└── Monitor: Prometheus + Grafana
```

---

### 2.10 Analytics & Monitoring

#### Design Ad Click Aggregation
**Companies:** Google, Facebook, Amazon, Twitter

**Requirements:**
- Count ad clicks per ad_id per minute
- Query: total clicks for ad_id in time range
- At-scale: 1B clicks/day = ~11K clicks/sec

**Architecture:**
```
Ad Click Event → Kafka
  → Stream Processor (Apache Flink)
      → Aggregate: COUNT per ad_id per 1-minute window
      → Write to Time-Series DB (InfluxDB / Cassandra)
  → Batch Processor (Spark, hourly reconciliation)
      → S3 raw logs → Spark aggregate → Data Warehouse (Redshift)

Query Service:
  → Time-series query → InfluxDB (real-time last 24h)
  → Historical query → Data Warehouse
```

---

#### Design Metrics / Monitoring System (Prometheus / Datadog)
**Companies:** All, SRE teams

**Architecture:**
```
Services → expose /metrics endpoint (Prometheus pull) or push to agent
  → Prometheus → scrape metrics every 15s
  → TSDB (time-series DB): metric_name{labels} → [(timestamp, value)]
  → Alertmanager → evaluate alert rules → PagerDuty / Slack
  → Grafana → visualize dashboards

Long-term storage:
  → Thanos / Cortex → remote_write to S3/GCS + compaction
```

---

#### Design Logging System (ELK Stack)
**Companies:** Elastic, all companies

**Architecture:**
```
Services → log to stdout / file
  → Log Collector: Filebeat / Fluentd → Logstash (parse, filter, enrich)
  → Elasticsearch (store + index logs)
  → Kibana (dashboards, search UI)
  → Retention: hot (ES, 7 days) → warm (ES, 30 days) → cold (S3, years)
```

---

#### Design Real-time Analytics Dashboard
**Companies:** Mixpanel, Amplitude, Segment

**Architecture:**
```
Client events → API → Kafka
  → Flink (real-time aggregation): DAU, MAU, events/sec
  → ClickHouse / Druid (OLAP, fast aggregation queries)
  → API → Dashboard (WebSocket for real-time push)

Batch:
  → Spark → Data Warehouse (Redshift) → Tableau/Looker
```

---

### 2.11 Gaming & Real-time

#### Design Real-time Gaming Leaderboard
**Companies:** Epic Games, Riot Games, Zynga, all gaming

**Functional Requirements:**
- Update player score
- Get rank of a player
- Top-K leaderboard
- Regional/global/friend leaderboard

**Architecture:**
```
Score Update → Redis Sorted Set:
  ZADD leaderboard score player_id      → O(log N)
  ZRANK leaderboard player_id           → O(log N)  (rank)
  ZREVRANGE leaderboard 0 9 WITHSCORES  → O(log N + K) (top-10)

Persistence:
  → Periodic snapshot → PostgreSQL (for restart recovery)
  → Kafka (score events) → batch update to DB

Segmentation:
  → Global: one sorted set
  → Regional: key = "leaderboard:region:us"
  → Friends: smaller set per user (maintained on friend add/remove)
```

---

#### Design Distributed Key-Value Store (DynamoDB / Cassandra)
**Companies:** Amazon (DynamoDB), Facebook (Cassandra), all

**Architecture:**
```
Consistent Hashing → assign key ranges to nodes
Replication: write to N nodes, ack after W writes (quorum)
Read: read from R nodes (quorum)
→ Tunable consistency: W + R > N → strong; else eventual

Components:
├── Coordinator Node: receive request, route to replicas
├── Gossip Protocol: node membership, failure detection
├── Bloom Filter: efficiently check if key might exist
├── Compaction: merge SSTables (LSM Tree)
└── Hinted Handoff: store writes for down nodes temporarily
```

---

#### Design Pub-Sub System (Kafka-like)
**Companies:** LinkedIn, Confluent, Google Cloud

> See Kafka section in 2.9

---

### 2.12 Maps & Location

#### Design Google Maps / Navigation
**Companies:** Google, Apple, HERE, Waze, Uber

**Functional Requirements:**
- Search places
- Turn-by-turn directions
- Traffic-aware routing
- ETA calculation
- Live traffic updates

**Architecture:**
```
├── Map Tiles Service
│     → Pre-rendered raster tiles (XYZ tiles) → CDN
│     → Vector tiles (zoom-dependent, rendered client-side)
├── Search Service → Elasticsearch (place name, address)
│     → Geocoding (address → lat/lng) + Reverse geocoding
├── Routing Service
│     → Graph: road network (node=intersection, edge=road segment)
│     → Algorithm: Dijkstra (small), A* (heuristic), Contraction Hierarchies (large scale)
│     → Pre-compute shortcuts for highway/freeway
├── Traffic Layer
│     → GPS data from drivers → aggregate speed per road segment → Kafka
│     → Flink → real-time traffic updates → update routing weights
│     → Historical: ML model (predict traffic by time/day)
└── ETA: routing time + traffic model + ML corrections
```

---

#### Design Location Tracking Service (real-time)
**Companies:** Uber, DoorDash, Google, Apple Find My

**Architecture:**
```
Client (driver/device) → WebSocket → Location Ingestion Service
  → Kafka (location events: device_id, lat, lng, timestamp, speed, bearing)
  → Redis (device_id → latest location) — for real-time queries
  → Cassandra (location history: device_id, timestamp → location) — for replay/history
  → Geospatial index (H3/S2) — for proximity queries
```

---

### 2.13 Collaboration Tools

#### Design Google Docs / Collaborative Editing
**Companies:** Google, Microsoft (Office 365), Notion, Figma

**Functional Requirements:**
- Multiple users edit same document simultaneously
- Real-time sync with no conflicts
- Offline editing + sync on reconnect
- Version history
- Comments + suggestions

**Key Algorithm — Conflict Resolution:**

| Approach | Description | Used By |
|----------|-------------|---------|
| **Operational Transformation (OT)** | Transform concurrent operations for consistency | Google Docs |
| **CRDT** (Conflict-free Replicated Data Types) | Mathematically guaranteed convergence | Figma, Notion |
| **Last Write Wins** | Simplest, loses data | Not suitable |

**Architecture:**
```
Client → WebSocket → Collaboration Server
  → Operation log: Kafka (op: INSERT/DELETE/FORMAT at position)
  → OT Engine: transform + apply operation to shared state
  → Broadcast to all connected clients
  → Document DB: Google Bigtable (document_id → revision history)
  → Snapshot: periodic full document snapshot → S3

Offline:
  → Local buffer → sync on reconnect → OT reconciliation
```

---

#### Design GitHub / Version Control System
**Companies:** GitHub, GitLab, Bitbucket

**Functional Requirements:**
- Git repository hosting (push, pull, clone)
- Pull requests, code review, comments
- CI/CD integration
- Issues, wikis, projects
- Access control

**Architecture:**
```
├── Git Storage: Packfiles + object store (blobs, trees, commits, tags)
│     → Content-addressed (SHA1 hash)
│     → Distributed across sharded NFS/custom object store
├── API Service → REST + GraphQL
├── Web UI → render diffs, blame, history
├── PR Service → merge simulation, conflict detection
├── Search: Elasticsearch (code search, issues)
├── CI/CD: GitHub Actions → containerized workers
│     → Webhook → trigger pipeline → Kubernetes pods
└── Notification: Observer pattern at service level
```

---

### 2.14 Booking & Reservation

#### Design Airbnb
**Companies:** Airbnb, Booking.com, Expedia, Vrbo

**Functional Requirements:**
- List properties with photos, pricing, availability
- Search (location, dates, guests, filters)
- Booking with hold (no double booking)
- Reviews, host/guest ratings
- Messaging between host and guest

**Architecture:**
```
├── Property Service → Elasticsearch (search) + PostgreSQL (details)
│     → S3 + CDN (photos)
├── Search Service
│     → Geospatial search (H3/PostGIS)
│     → Date availability filter (calendar check)
│     → Price + filter ranking
├── Booking Service
│     → Availability Calendar: Redis (property_id:date → status)
│     → Reservation: PostgreSQL (SERIALIZABLE isolation to prevent double booking)
│     → Payment hold → Stripe payment intent
├── Messaging: similar to WhatsApp mini
├── Review Service: PostgreSQL
└── Pricing: dynamic pricing ML model (demand, season, events)
```

**Double Booking Prevention:**
```
Option A: DB row-level lock (SELECT FOR UPDATE on date range)
Option B: Redis distributed lock (SETNX with TTL)
Option C: Optimistic locking (version number + CAS)
→ Use DB serializable transaction + optimistic locking
```

---

#### Design Ticketmaster / BookMyShow
**Companies:** Ticketmaster, BookMyShow, StubHub, SeatGeek

**Functional Requirements:**
- Browse events (concerts, sports, theatre)
- Seat selection (interactive map)
- No double booking (hot contention at sale start)
- Payment + e-ticket

**Flash Sale Problem:**
```
At ticket release:
  → Traffic spike: 10K users/sec for 1K seats
  → Virtual Waiting Room: queue users → issue token in order
  → Seat Lock: Redis SETNX (seat_id → user_id, TTL=10min) → reserve
  → Payment within TTL → confirm in PostgreSQL
  → Release lock if payment fails
```

---

### 2.15 Health, Finance & Misc

#### Design Stock Exchange / Trading System
**Companies:** NASDAQ, NYSE, Robinhood, Zerodha, Goldman Sachs

**Functional Requirements:**
- Place orders (Market, Limit, Stop-Loss, Stop-Limit)
- Order matching engine (price-time priority)
- Real-time price feed
- Portfolio + P&L
- Trade settlement (T+2)

**Architecture:**
```
├── Order Service → Kafka (order events)
├── Order Book: in-memory (sorted by price × time)
│     → Buy side: max-heap (highest bid first)
│     → Sell side: min-heap (lowest ask first)
│     → Match: if best_bid ≥ best_ask → execute trade
├── Matching Engine: single-threaded (no locks needed), ultra-low latency
├── Market Data Service → Kafka → Redis (current price) → WebSocket → clients
├── Settlement Service → post-trade processing, T+2 clearing
└── Risk Management: pre-trade checks (balance, position limits)
```

---

#### Design IoT Platform
**Companies:** AWS IoT, Azure IoT, Google Cloud IoT, various

**Architecture:**
```
IoT Devices → MQTT protocol (lightweight, pub/sub)
  → IoT Gateway / MQTT Broker (Mosquitto, AWS IoT Core)
  → Kafka (ingest events: device_id, sensor_type, value, timestamp)
  → Stream Processing (Flink) → anomaly detection, aggregation
  → Time-Series DB (InfluxDB/TimescaleDB)
  → Command Service → send commands back to devices
  → Dashboard → WebSocket → real-time monitoring
```

---

#### Design A/B Testing Platform
**Companies:** Google, Facebook, Airbnb (Experimentation Platform), Booking.com

**Functional Requirements:**
- Create experiments (control vs treatment groups)
- Consistent user assignment (same user always in same group)
- Collect metrics per variant
- Statistical significance calculation
- Feature flags

**Architecture:**
```
├── Experiment Service: define experiment (id, variants, traffic split)
├── Assignment Service
│     → Hash(user_id + experiment_id) % 100 → variant
│     → Redis cache: user_id:experiment_id → variant
├── Event Tracking: Kafka → Flink → metrics per variant
├── Analysis Service: t-test / chi-square → p-value → significance
└── Feature Flag Service: gradual rollout (% of users)
```

---

## 3. Key Concepts Deep Dive

### 3.1 Data Flow Patterns

| Pattern | Description | Use Case |
|---------|-------------|---------|
| **Lambda Architecture** | Batch layer (accuracy) + Speed layer (real-time) + Serving layer | Analytics with historical + real-time |
| **Kappa Architecture** | Only streaming (Kafka), replay for batch | Simpler, modern streaming |
| **CQRS** | Separate read + write models | Read-heavy with complex queries |
| **Event Sourcing** | Store events, derive state | Audit trail, time travel, microservices |
| **Saga Pattern** | Distributed transaction via events | Microservices, no 2PC |
| **Outbox Pattern** | Transactionally write events to DB outbox → relay to Kafka | Guaranteed event delivery |

---

### 3.2 Database Selection Guide

```
Scenario → Recommended DB:

User profiles, structured data, relationships → PostgreSQL / MySQL
Shopping cart, sessions, leaderboard → Redis
Product catalog, flexible schema → MongoDB
Messaging, write-heavy, time-series → Cassandra
Search, autocomplete, full-text → Elasticsearch
Social graph, connections → Neo4j
Analytics, OLAP queries → ClickHouse / Redshift / BigQuery
Files, blobs, large objects → S3
Configuration, coordination, leader election → Zookeeper / etcd
Real-time messaging, pub-sub → Redis Pub/Sub / Kafka
```

---

### 3.3 Estimation Template

```
Step 1: Clarify scale
  - DAU / MAU
  - Reads per day vs Writes per day
  - Data size per record

Step 2: Calculate QPS
  - Read QPS = DAU × reads_per_user / 86400
  - Write QPS = DAU × writes_per_user / 86400
  - Peak = 2–5× average

Step 3: Calculate storage
  - Daily data = writes_per_day × record_size
  - 5-year storage = daily × 365 × 5

Step 4: Bandwidth
  - Ingress = write_QPS × record_size
  - Egress = read_QPS × record_size
```

---

### 3.4 Availability Numbers

```
Availability → Downtime per year:
  99%      → 3.65 days
  99.9%    → 8.77 hours
  99.99%   → 52.6 minutes
  99.999%  → 5.26 minutes
  99.9999% → 31.5 seconds
```

---

## 4. Company-wise Questions

### Google

| System | Key Concepts |
|--------|-------------|
| Google Search (Crawler + Indexer + Ranking) | Inverted index, PageRank, MapReduce, Bigtable |
| Google Maps | Graph shortest path (CH), vector tiles, real-time traffic, CDN |
| YouTube | Video transcoding pipeline, CDN, adaptive bitrate (DASH), recommendation ML |
| Gmail | SMTP, search index, label system, spam ML |
| Google Drive | Chunked upload, delta sync, composite file storage |
| Google Docs | OT (operational transformation), WebSocket, CRDTs |
| Google Ads / AdSense | Click aggregation (Flink), auction (Vickrey), fraud detection |
| Google Photos | Object storage, image recognition ML, deduplication |
| Search Autocomplete (642) | Trie + top-K + personalization |
| Web Crawler | BFS frontier, politeness, SimHash, Bloom Filter |
| Rate Limiter | Token bucket, sliding window, distributed Redis |

---

### Amazon / AWS

| System | Key Concepts |
|--------|-------------|
| Amazon Shopping | Product catalog (ES), inventory (Redis), order state machine, flash sale |
| Amazon S3 | Object storage, consistent hashing, erasure coding, 11-nines durability |
| DynamoDB | LSM tree, consistent hashing, quorum reads/writes, GSI/LSI |
| Amazon SQS/SNS | Message queue, pub-sub, fan-out, FIFO queue |
| Amazon Prime Video | CDN, adaptive bitrate, DRM, recommendation |
| Alexa | NLP pipeline, intent recognition, skill execution |
| Amazon Recommendation | Collaborative filtering, item-item CF, A/B testing |
| AWS Lambda | Serverless, cold start, event-driven scaling |
| Payment System | Idempotency, ledger, Stripe integration |
| Notification System | Observer, multi-channel, retry |

---

### Facebook / Meta

| System | Key Concepts |
|--------|-------------|
| Facebook News Feed | TAO (graph), EdgeRank, fanout on write, Haystack (photo storage) |
| Instagram | Feed fanout hybrid, media CDN, explore |
| WhatsApp | WebSocket, Ejabberd, offline queue, E2E encryption |
| Messenger | Real-time, message threads, presence |
| Facebook Live | RTMP ingest, SFU, chat fanout |
| Facebook Search | Unicorn (distributed search), typeahead |
| Ad System | RTB (real-time bidding), Click aggregation, budget pacing |
| Notifications | Multi-channel, priority, rate limiting |

---

### Microsoft

| System | Key Concepts |
|--------|-------------|
| Microsoft Teams | WebRTC, SFU, channels, WebSocket, search |
| OneDrive | Delta sync, SharePoint integration, conflict resolution |
| Outlook / Exchange | SMTP, IMAP, calendar sync, spam filter |
| Azure Cosmos DB | Multi-model, global distribution, 5 consistency levels |
| GitHub (acquired) | Git packfiles, PR workflow, Actions CI/CD |
| Bing Search | Crawler, index, ranking |
| Xbox Leaderboard | Redis sorted set, regional partitioning |

---

### Uber

| System | Key Concepts |
|--------|-------------|
| Uber Ride Matching | H3 geospatial, WebSocket, driver location (Redis), dispatch algorithm |
| Surge Pricing | Real-time supply vs demand per H3 cell, ML adjustment |
| Uber Eats | Same as ride matching + restaurant/order management |
| Driver Location Tracking | Kafka, Redis, H3, WebSocket |
| Payment & Reconciliation | Stripe, idempotency, event sourcing |
| Notification System | Push, SMS, multi-channel |

---

### Twitter / X

| System | Key Concepts |
|--------|-------------|
| Twitter Feed | Fanout on write vs read, hybrid for celebs, Redis timeline cache |
| Trending Topics | Count hashtags in sliding window → Redis sorted set, approximate counting |
| URL Shortener (t.co) | Base62, redirect, click analytics |
| Tweet Counts (1348) | HashMap + sorted timestamps |
| Rate Limiter | Token bucket, sliding window counter |
| Real-time Search | Lucene, Blending user/trends/news |

---

### Netflix

| System | Key Concepts |
|--------|-------------|
| Video Streaming | CDN (Open Connect), adaptive bitrate (DASH), edge caching |
| Content Transcoding | FFmpeg, parallel processing, multiple codecs |
| Recommendation | Collaborative filtering, A/B testing, offline Spark + online serving |
| Resilience | Hystrix (circuit breaker), Chaos Monkey, multi-region |
| Playback API | Signed CDN URLs, DRM, device detection |

---

### LinkedIn

| System | Key Concepts |
|--------|-------------|
| LinkedIn Feed | Graph (member graph), feed ranking, Kafka-based fanout |
| Job Search | Elasticsearch, skills graph, recommendation |
| People You May Know | BFS on connection graph, Spark batch, common connections |
| Kafka (built here) | Topic partitions, consumer groups, offset management |
| Search (People) | Typeahead, Galene search (LinkedIn's ES) |

---

### Airbnb

| System | Key Concepts |
|--------|-------------|
| Property Search | Elasticsearch + geospatial, date availability filter |
| Booking System | Distributed lock, double booking prevention, payment hold |
| Dynamic Pricing | ML (demand, season, local events) |
| Review System | Bi-directional (host + guest), fraud detection |
| Experimentation | A/B testing platform |

---

### Stripe / PayPal

| System | Key Concepts |
|--------|-------------|
| Payment Processing | Idempotency key, double-entry ledger, TLS, PCI-DSS |
| Webhook Delivery | At-least-once, retry with exponential backoff, dead letter |
| Fraud Detection | Real-time ML scoring, velocity checks, rules engine |
| Reconciliation | Batch jobs matching bank records |

---

### Dropbox

| System | Key Concepts |
|--------|-------------|
| File Sync | Delta sync, chunk deduplication, content-addressed storage |
| Conflict Resolution | Copy-on-conflict, version history |
| Notification | Long polling → WebSocket for sync signal |

---

### Discord

| System | Key Concepts |
|--------|-------------|
| Real-time Messaging | WebSocket, Elixir/BEAM (concurrency), Cassandra messages |
| Voice/Video | WebRTC, Selective Forwarding Unit |
| Guilds/Channels | Fan-out to all online members in channel |
| Read States | Cassandra (user_id:channel_id → last_read_id) |

---

## 5. Trade-off Decision Framework

### How to Approach Any HLD Interview

```
Step 1: Requirements (5 min)
  Functional:  What does the system DO?
  Non-functional: Scale? Latency? Availability? Consistency?
  Constraints: Budget? Existing tech stack? Team size?

Step 2: Estimation (3 min)
  QPS = DAU × actions/day / 86400
  Storage = records/day × record_size × retention_years
  Bandwidth = QPS × record_size

Step 3: High-level Design (10 min)
  Draw: Client → LB → Services → DB → Cache → Queue
  Identify: Read-heavy or Write-heavy?

Step 4: Deep Dive (20 min)
  Pick 2-3 critical components to detail:
  - DB schema + sharding strategy
  - Cache strategy + eviction
  - Queue design + consumer pattern
  - Consistency model justification

Step 5: Bottlenecks & Trade-offs (5 min)
  - SPOF? → Replicate
  - Hotspot? → Shard or cache
  - Slow writes? → Async via queue
  - Slow reads? → Add cache, read replicas, CDN
  - Consistency? → CAP, eventual vs strong
```

### Common Trade-off Cheat Sheet

| Decision | Option A | Option B | Choose Based On |
|----------|----------|----------|----------------|
| SQL vs NoSQL | ACID, relations, complex queries | Scale, flexible schema, speed | Data structure + scale needed |
| Cache aside vs write-through | Low coupling, stale possible | Always fresh, double write | Read/write ratio |
| Push vs Pull (feed) | Fast reads, slow writes, fan-out issue | Slow reads, simple writes | Celebrity ratio |
| WebSocket vs Polling | Real-time, persistent connection | Simple, stateless | Latency requirement |
| Sync vs Async | Simple, immediate feedback | Scalable, decoupled, delayed | Latency vs throughput |
| Monolith vs Microservices | Simple deploy, no network | Independent scale, complex | Team size + scale |
| Strong vs Eventual consistency | Always correct, lower availability | Always available, stale possible | Business requirement |
| Sharding by hash vs range | Uniform, no range queries | Range queries work, hotspots | Access pattern |
| CDN push vs pull | Fresh content ready | Less storage, on-demand | Update frequency |
| Replication sync vs async | No data loss, slower writes | Faster writes, possible data loss | Durability requirement |
