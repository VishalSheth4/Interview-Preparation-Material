# LLD Interview Questions — Complete Reference

> Covers all LLD problems, design patterns used, and company-wise breakdown.

---

## Table of Contents

1. [Design Patterns Reference](#1-design-patterns-reference)
   - [Creational](#11-creational-patterns)
   - [Structural](#12-structural-patterns)
   - [Behavioral](#13-behavioral-patterns)
2. [LLD Problems by Category](#2-lld-problems-by-category)
   - [Parking & Transportation](#21-parking--transportation)
   - [Games](#22-games)
   - [Booking & Reservation Systems](#23-booking--reservation-systems)
   - [E-Commerce & Retail](#24-e-commerce--retail)
   - [Food & Delivery](#25-food--delivery)
   - [Banking & Finance](#26-banking--finance)
   - [Social & Messaging](#27-social--messaging)
   - [Streaming & Media](#28-streaming--media)
   - [Infrastructure & Backend](#29-infrastructure--backend)
   - [Healthcare & Education](#210-healthcare--education)
   - [Miscellaneous Systems](#211-miscellaneous-systems)
3. [LeetCode Design Problems](#3-leetcode-design-problems)
4. [Company-wise Questions](#4-company-wise-questions)
5. [Design Pattern → Problem Mapping](#5-design-pattern--problem-mapping)

---

## 1. Design Patterns Reference

### 1.1 Creational Patterns

| Pattern | Intent | When to Use | LLD Problems It Appears In |
|---------|--------|-------------|---------------------------|
| **Singleton** | One instance globally | Logger, Config, DB Connection Pool | Logger, ATM, Vending Machine, Parking Lot |
| **Factory Method** | Subclass decides which object to create | Create objects without specifying exact class | Vehicle Factory, Pizza Factory, Notification Factory |
| **Abstract Factory** | Family of related objects | UI themes, Cross-platform widgets | Smart Home Devices, Game Piece Factory |
| **Builder** | Step-by-step construction of complex objects | Objects with many optional fields | Pizza Order, HTTP Request, User Profile |
| **Prototype** | Clone existing objects | Avoid costly creation, copy game states | Chess Board Clone, Template Documents |
| **Object Pool** | Reuse expensive objects | DB connections, Thread pools | Connection Pool, Thread Pool Manager |

---

### 1.2 Structural Patterns

| Pattern | Intent | When to Use | LLD Problems It Appears In |
|---------|--------|-------------|---------------------------|
| **Adapter** | Convert incompatible interface | Wrap legacy/third-party code | Payment Gateway Adapter, Log Formatter |
| **Bridge** | Decouple abstraction from implementation | Independent variation of both | Remote Control & Devices, Notification Channels |
| **Composite** | Tree structure, treat leaf = composite | File systems, Menus, UI hierarchy | File System, Organization Hierarchy, Menu System |
| **Decorator** | Add behavior dynamically | Wrap object to extend functionality | Pizza Toppings, Coffee Condiments, Log Levels |
| **Facade** | Simplified interface over complex subsystem | Reduce coupling to internals | Hotel Booking Facade, ATM Facade |
| **Flyweight** | Share common state across many objects | Memory optimization for large counts | Chess Pieces, Game Particles, Text Characters |
| **Proxy** | Placeholder that controls access | Lazy loading, caching, security | Virtual Proxy for images, Protection Proxy |

---

### 1.3 Behavioral Patterns

| Pattern | Intent | When to Use | LLD Problems It Appears In |
|---------|--------|-------------|---------------------------|
| **Chain of Responsibility** | Pass request along handler chain | Logging levels, Auth middleware, Approvals | Vending Machine, ATM (denomination), Approval Workflow |
| **Command** | Encapsulate request as object | Undo/Redo, Queuing operations | Text Editor (undo), Smart Home, Transaction |
| **Iterator** | Sequential access without exposing internals | Traverse collections | File Iterator, Playlist, Search Results |
| **Mediator** | Centralized communication between objects | Chat rooms, Air traffic control | Chat System, Auction System, Traffic Signal |
| **Memento** | Capture/restore object state | Undo/Redo functionality | Text Editor, Game Save, Form Data |
| **Observer** | Notify dependents on state change | Event systems, Pub-Sub | Notification System, Stock Ticker, News Feed |
| **State** | Alter behavior based on internal state | State machines | Vending Machine, ATM, Elevator, Traffic Light |
| **Strategy** | Swap algorithms at runtime | Sorting strategies, Payment methods | Payment Gateway, Discount Strategy, Route Finder |
| **Template Method** | Skeleton algorithm, steps vary by subclass | Define workflow with hook methods | Data Exporters, Report Generation |
| **Visitor** | Add operations without modifying classes | Traversal + operations on tree/graph | AST Evaluation, Tax Calculation |
| **Interpreter** | Grammar for language | Expression evaluators | Calculator, SQL Parser, Regular Expressions |
| **Null Object** | Default no-op implementation | Avoid null checks | Null Logger, Null User |

---

## 2. LLD Problems by Category

---

### 2.1 Parking & Transportation

#### Parking Lot System
**Companies:** Google, Amazon, Microsoft, Uber, Lyft, Walmart, Adobe, Salesforce, Goldman Sachs

**Core Requirements:**
- Multiple floors, multiple spots (Compact, Large, Handicapped, Motorcycle)
- Entry/Exit gates with tickets
- Pricing strategy (hourly, flat rate)
- Spot availability tracking
- Payment processing

**Classes to Design:**
```
ParkingLot (Singleton)
├── ParkingFloor[]
│   └── ParkingSpot[] (Compact / Large / Handicapped / Motorcycle)
├── EntrancePanel / ExitPanel
├── Ticket (vehicle info, spot, entry time)
├── ParkingTicket
├── Vehicle (Car, Truck, Motorcycle, Van)
├── ParkingDisplayBoard
├── PaymentService
│   ├── CashPayment
│   └── CardPayment
└── PricingStrategy (Strategy Pattern)
    ├── HourlyPricing
    └── FlatRatePricing
```

**Design Patterns:** Singleton (ParkingLot), Strategy (Pricing), Factory (Vehicle), State (Spot status), Observer (DisplayBoard)

---

#### Elevator System
**Companies:** Google, Amazon, Microsoft, JP Morgan

**Core Requirements:**
- Multiple elevators, multiple floors
- Request dispatching (optimize for nearest / direction-based)
- States: Moving Up, Moving Down, Idle
- Button panels inside and outside

**Classes to Design:**
```
ElevatorSystem
├── Elevator[]
│   ├── ElevatorState (IDLE, MOVING_UP, MOVING_DOWN)
│   ├── InternalButtons[]
│   └── Door
├── ExternalButton (floor request)
├── Dispatcher (Strategy: FCFS / SSTF / SCAN / LOOK)
└── ElevatorController
```

**Design Patterns:** State (Elevator states), Strategy (Dispatcher algorithm), Observer (button presses)

---

#### Ride Sharing System (Uber/Lyft/Ola)
**Companies:** Uber, Lyft, Ola, DoorDash, Grab

**Core Requirements:**
- Rider requests ride with pickup/drop
- Driver matching (nearest driver, surge pricing)
- Trip states: Requested → Driver Assigned → Pickup → In Progress → Completed
- Rating system
- Fare calculation

**Classes to Design:**
```
RideSharingApp
├── User (Rider / Driver)
├── Location (lat, lng)
├── Trip
│   ├── TripStatus (State Pattern)
│   └── Route
├── DriverMatchingService (Strategy: Nearest / Rating-based)
├── FareCalculationStrategy
│   ├── StandardFare
│   └── SurgePricingFare
├── PaymentService
├── RatingService
└── NotificationService (Observer)
```

**Design Patterns:** State (Trip status), Strategy (Matching + Pricing), Observer (Notifications), Factory (User types)

---

#### Car Rental System
**Companies:** Enterprise, Hertz, OYO, various startups

**Core Requirements:**
- Vehicles: Economy, SUV, Luxury, Van
- Reservation, pickup, return
- Damage tracking
- Dynamic pricing

**Classes to Design:**
```
CarRentalSystem
├── Vehicle (abstract) → Economy, SUV, Luxury, Van
├── Reservation
├── Branch (location-based fleet)
├── Member / Account
├── RentalPricingStrategy
└── PaymentService
```

**Design Patterns:** Strategy (Pricing), Factory (Vehicle types), Template Method (Rental workflow)

---

#### Traffic Signal System
**Companies:** Google, Microsoft, Waymo

**Core Requirements:**
- Signals cycle: Red → Green → Yellow → Red
- Multiple roads/intersections
- Timer management
- Emergency override

**Classes to Design:**
```
TrafficController
├── TrafficSignal[]
│   └── SignalState (State Pattern: RED, GREEN, YELLOW)
├── Timer
└── EmergencyHandler
```

**Design Patterns:** State (Signal states), Observer (Timer events), Singleton (TrafficController)

---

#### Flight Booking System
**Companies:** MakeMyTrip, Expedia, Booking.com, Kayak, Cleartrip

**Core Requirements:**
- Search flights (origin, destination, date, class)
- Seat selection
- Booking + cancellation
- Pricing tiers (Economy, Business, First Class)

**Classes to Design:**
```
FlightBookingSystem
├── Flight
│   ├── Seat[]
│   └── Itinerary
├── Aircraft
├── Airport
├── Passenger
├── Booking
│   └── BookingStatus (State Pattern)
├── FareStrategy
│   ├── EconomyFare
│   ├── BusinessFare
│   └── FirstClassFare
├── SearchService
└── PaymentService
```

**Design Patterns:** State (Booking status), Strategy (Fare), Composite (Itinerary legs), Observer (Flight status updates)

---

### 2.2 Games

#### Chess Game
**Companies:** Google, Facebook/Meta, Amazon, Microsoft, Apple

**Core Requirements:**
- 8×8 board, all 6 piece types with move rules
- Turn management (White/Black)
- Check, Checkmate, Stalemate detection
- Special moves: Castling, En Passant, Promotion

**Classes to Design:**
```
ChessGame
├── Board (8×8 Cell[][])
├── Cell (position, Piece)
├── Piece (abstract)
│   ├── King, Queen, Bishop, Knight, Rook, Pawn
│   └── move(Board, from, to): bool
├── Player (Human / Computer)
├── Move (from, to, special type)
├── GameController
│   └── GameStatus (ACTIVE, CHECK, CHECKMATE, STALEMATE)
└── MoveValidator
```

**Design Patterns:** Strategy (piece movement), State (game status), Command (Move → undo), Flyweight (piece images/shared data)

---

#### Tic Tac Toe
**Companies:** Google, Amazon, Facebook, Microsoft, Oracle

**Core Requirements:**
- N×N board (configurable)
- 2 players (Human / AI)
- Win/Draw detection
- Undo move

**Classes to Design:**
```
TicTacToe
├── Board (N×N)
├── Player (Human / AI)
│   └── PlayingPiece (X / O)
├── GameController
└── WinConditionChecker
```

**Design Patterns:** Strategy (AI player), Command (undo move), State (game states)

---

#### Snake and Ladders
**Companies:** Microsoft, Amazon, Atlassian

**Core Requirements:**
- Configurable board size
- Snakes and ladders at specific positions
- Multiple players with dice
- Win condition

**Classes to Design:**
```
SnakeAndLadders
├── Board
│   ├── Cell[]
│   ├── Snake[] (start → end)
│   └── Ladder[] (start → end)
├── Player
├── Dice
└── GameController
```

**Design Patterns:** Strategy (dice rolling), Observer (player turn events)

---

#### Blackjack / Card Games
**Companies:** Goldman Sachs, various fintech

**Core Requirements:**
- Standard 52-card deck
- Dealer + players
- Blackjack rules (hit, stand, double down, split)

**Classes to Design:**
```
BlackjackGame
├── Deck (52 Cards)
├── Card (Suit × Rank)
├── Hand
├── Player (Human / Dealer)
│   └── PlayerAction (HIT, STAND, DOUBLE, SPLIT)
└── GameController
```

**Design Patterns:** State (game phases), Strategy (dealer strategy)

---

#### Bowling Alley
**Companies:** Amazon, various

**Core Requirements:**
- 10 frames, 10 pins per frame
- Strike, Spare, Normal scoring
- Multiple players

**Classes to Design:**
```
BowlingGame
├── Lane
├── Player
│   └── ScoreCard
│       └── Frame[]
│           └── Roll[]
└── ScoreCalculator
```

---

#### Online Chess / Multiplayer Game
**Companies:** Zynga, gaming companies

**Core Requirements:**
- Matchmaking
- Real-time game session
- Leaderboard

---

#### Vending Machine
**Companies:** Google, Amazon, Microsoft, Samsung

**Core Requirements:**
- States: Idle → Item Selected → Payment → Dispensing → Change Return
- Multiple payment methods
- Inventory management
- Exact change / no change scenarios

**Classes to Design:**
```
VendingMachine (Singleton)
├── VendingState (State Pattern)
│   ├── IdleState
│   ├── HasMoneyState
│   ├── SelectionState
│   └── DispenseState
├── Item (name, price, quantity)
├── Inventory
├── PaymentProcessor
│   ├── CashPayment
│   └── CardPayment
└── ChangeDispenser
```

**Design Patterns:** State (machine states), Strategy (payment), Singleton (machine instance), Chain of Responsibility (denomination selection)

---

### 2.3 Booking & Reservation Systems

#### Movie Ticket Booking (BookMyShow)
**Companies:** Amazon, Flipkart, PayTM, BookMyShow, Fandango

**Core Requirements:**
- Cities → Theatres → Movies → Shows
- Seat selection (locked during booking for N minutes)
- Concurrent booking (no double booking)
- Payment + confirmation

**Classes to Design:**
```
MovieTicketBookingSystem
├── City → Theatre → Hall → Seat[]
├── Movie
├── Show (Movie × Hall × DateTime)
├── Booking
│   └── BookingStatus (REQUESTED, PENDING_PAYMENT, CONFIRMED, CANCELLED)
├── SeatLock (TTL-based)
├── BookingService
├── SearchService
├── PaymentService
└── NotificationService (Observer)
```

**Design Patterns:** State (Booking status), Observer (notifications), Singleton (BookingService), Strategy (seat selection)

---

#### Hotel Management System
**Companies:** Booking.com, Expedia, Airbnb, OYO, MakeMyTrip

**Core Requirements:**
- Room types: Standard, Deluxe, Suite
- Reservation: check-in, check-out, cancellation
- Housekeeping status
- Billing (room + services)

**Classes to Design:**
```
HotelManagementSystem
├── Hotel → Floor → Room
│   ├── RoomType (Standard / Deluxe / Suite)
│   └── RoomStatus (AVAILABLE, RESERVED, OCCUPIED, MAINTENANCE)
├── Guest / Account
├── Reservation
├── RoomBookingService
├── CheckInService / CheckOutService
├── HousekeepingService
└── BillingService
```

**Design Patterns:** State (Room status), Strategy (Pricing), Factory (Room types), Observer (Housekeeping alerts)

---

#### Restaurant Reservation System
**Companies:** OpenTable, Zomato, Yelp

**Core Requirements:**
- Table management (capacity, location)
- Time slot booking
- Waitlist
- Menu + ordering

**Classes to Design:**
```
RestaurantSystem
├── Restaurant → Table[]
├── Reservation
│   └── ReservationStatus
├── MenuItem / Menu
├── Order → OrderItem[]
├── WaitlistService
└── BillingService
```

---

#### Event Booking System (BookMyShow events)
**Companies:** BookMyShow, Eventbrite, Ticketmaster

**Core Requirements:**
- Events: concerts, sports, theatre
- Venue seating (zones, rows, seats)
- Flash sale / waitlist
- Cancellation policy

**Design Patterns:** State (Booking), Observer (Waitlist), Strategy (Pricing tiers)

---

#### My Calendar / Meeting Scheduler
**Companies:** Google, Microsoft, Calendly
*(LeetCode 729, 731, 732)*

**Core Requirements:**
- Add events without double booking
- Find free slots
- Recurring events
- Time zone support

**Classes to Design:**
```
CalendarSystem
├── Calendar (per user)
├── Event (start, end, title, recurring)
├── TimeSlot
├── SchedulerService
└── ConflictDetector
```

---

### 2.4 E-Commerce & Retail

#### Online Shopping System (Amazon)
**Companies:** Amazon, Flipkart, Walmart, eBay

**Core Requirements:**
- Product catalog (categories, search, filters)
- Cart → Order → Payment → Shipment
- Inventory management
- Reviews + ratings

**Classes to Design:**
```
OnlineShoppingSystem
├── User / Account
├── Product → ProductCategory
├── ShoppingCart → CartItem[]
├── Order
│   └── OrderStatus (PLACED, CONFIRMED, SHIPPED, DELIVERED, RETURNED)
├── Payment
│   ├── CreditCard
│   ├── UPI
│   └── Wallet
├── Shipment → ShipmentStatus
├── InventoryService
├── SearchService
└── ReviewService
```

**Design Patterns:** State (Order status), Strategy (Payment, Shipping, Discount), Observer (Order notifications), Decorator (Discount + Tax on price)

---

#### Flash Sale / Inventory System
**Companies:** Amazon, Flipkart, Myntra

**Core Requirements:**
- Limited stock items, high concurrent demand
- Rate limiting per user
- Queue-based fair ordering

**Design Patterns:** Strategy (Rate Limiting), Observer (stock updates), Singleton (InventoryManager)

---

#### Inventory Management System
**Companies:** Amazon, Walmart, Flipkart, Target

**Core Requirements:**
- Track stock across multiple warehouses
- Reorder thresholds
- Supplier management
- Barcode / SKU lookup

**Classes to Design:**
```
InventorySystem
├── Warehouse → WarehouseItem[]
├── Product (SKU, barcode)
├── Supplier
├── PurchaseOrder
├── ReorderService (Observer: low stock)
└── ReportService
```

**Design Patterns:** Observer (reorder alerts), Strategy (reorder policy)

---

#### Auction System (eBay)
**Companies:** eBay, OLX, various

**Core Requirements:**
- English auction (ascending bid), Dutch (descending), Sealed bid
- Bid validation, auto-bidding
- Auction end timer
- Notification to bidders

**Classes to Design:**
```
AuctionSystem
├── AuctionListing
│   └── AuctionStatus (CREATED, ACTIVE, CLOSED, SOLD)
├── Bid
├── Bidder
├── AuctionStrategy (Strategy Pattern)
│   ├── EnglishAuction
│   ├── DutchAuction
│   └── SealedBidAuction
├── AutoBidService
└── NotificationService (Observer)
```

**Design Patterns:** Strategy (auction type), Observer (bid notifications), State (auction status)

---

#### Shopping Cart / Discount System
**Companies:** All e-commerce

**Core Requirements:**
- Add/remove items
- Apply coupons (percentage, flat, BOGO)
- Stack discounts
- Tax calculation

**Classes to Design:**
```
Cart
├── CartItem[]
├── DiscountStrategy (Strategy)
│   ├── PercentageDiscount
│   ├── FlatDiscount
│   ├── BOGODiscount
│   └── CouponDiscount
├── TaxCalculator
└── PricingEngine
```

**Design Patterns:** Strategy (discount), Decorator (stacking discounts + tax), Chain of Responsibility (coupon validation)

---

### 2.5 Food & Delivery

#### Food Delivery System (Swiggy / Zomato / DoorDash)
**Companies:** Swiggy, Zomato, DoorDash, Uber Eats, Grab Food

**Core Requirements:**
- Browse restaurants → menu → cart → order
- Assign delivery partner (nearest available)
- Real-time order tracking
- Rating for restaurant + delivery

**Classes to Design:**
```
FoodDeliverySystem
├── User (Customer / Restaurant / DeliveryPartner)
├── Restaurant → Menu → MenuItem
├── Cart → CartItem[]
├── Order
│   └── OrderStatus (PLACED, ACCEPTED, PREPARING, PICKED_UP, DELIVERED, CANCELLED)
├── DeliveryAssignment
│   └── DeliveryAssignmentStrategy (Nearest / Rating-based)
├── Location
├── PaymentService
├── RatingService
└── NotificationService (Observer)
```

**Design Patterns:** State (Order status), Strategy (delivery partner assignment + pricing), Observer (notifications), Factory (payment methods)

---

#### Pizza Ordering System (Domino's)
**Companies:** Domino's, Pizza Hut

**Core Requirements:**
- Build pizza: size × crust × sauce × toppings
- Track order: placed → baking → quality check → delivery
- Loyalty points

**Classes to Design:**
```
PizzaSystem
├── Pizza (Builder Pattern)
│   ├── Size, Crust, Sauce
│   └── Topping[] (Decorator Pattern)
├── Order → OrderStatus (State)
├── LoyaltyService
└── DeliveryService
```

**Design Patterns:** Builder (pizza construction), Decorator (toppings), State (order status), Strategy (pricing)

---

### 2.6 Banking & Finance

#### ATM Machine
**Companies:** Goldman Sachs, JP Morgan, Visa, Mastercard, Citibank

**Core Requirements:**
- States: Idle → Card Inserted → PIN Entered → Transaction → Eject
- Cash withdrawal (denomination selection)
- Deposit, balance check, transfer
- Daily limit enforcement

**Classes to Design:**
```
ATM (Singleton)
├── ATMState (State Pattern)
│   ├── IdleState
│   ├── CardInsertedState
│   ├── PINEnteredState
│   ├── TransactionState
│   └── OutOfCashState
├── Card → Account → Bank
├── CashDispenser (Chain of Responsibility for denominations)
├── Transaction
│   ├── Withdrawal
│   ├── Deposit
│   └── Transfer
├── Bank / NetworkService
└── ReceiptPrinter
```

**Design Patterns:** State (ATM states), Chain of Responsibility (denomination dispensing), Singleton (ATM), Strategy (transaction types)

---

#### Banking System
**Companies:** Goldman Sachs, JP Morgan, Morgan Stanley, Stripe

**Core Requirements:**
- Accounts: Savings, Checking, Fixed Deposit
- Transactions: Debit, Credit, Transfer
- Interest calculation
- Statement generation

**Classes to Design:**
```
BankingSystem
├── Customer → Account[]
│   ├── SavingsAccount
│   ├── CheckingAccount
│   └── FixedDepositAccount
├── Transaction
│   └── TransactionType (DEBIT, CREDIT, TRANSFER)
├── InterestCalculationStrategy
├── StatementService
└── NotificationService
```

**Design Patterns:** Strategy (interest calculation), Template Method (statement generation), Observer (transaction alerts)

---

#### Digital Wallet (PayTM / Google Pay / PhonePe)
**Companies:** PayTM, PhonePe, Google Pay, Amazon Pay, Stripe

**Core Requirements:**
- Add money, withdraw, transfer (P2P)
- Link bank accounts / cards
- Transaction history
- KYC limits

**Classes to Design:**
```
DigitalWallet
├── Wallet → Balance
├── User → KYCStatus
├── Transaction → TransactionStatus
├── PaymentMethod (BankAccount / Card / UPI)
├── MoneyTransferService
└── TransactionHistoryService
```

**Design Patterns:** Strategy (payment method), Observer (transaction notifications), State (KYC status)

---

#### Stock Trading System
**Companies:** Goldman Sachs, Morgan Stanley, Robinhood, Zerodha

**Core Requirements:**
- Buy/sell orders: Market, Limit, Stop-Loss
- Order matching engine (price-time priority)
- Portfolio tracking
- Real-time price feed

**Classes to Design:**
```
TradingSystem
├── Stock
├── Order (abstract)
│   ├── MarketOrder
│   ├── LimitOrder
│   └── StopLossOrder
├── OrderBook (buy heap + sell heap)
├── MatchingEngine
├── Portfolio → Position[]
├── MarketDataService (Observer for price)
└── TradeHistory
```

**Design Patterns:** Strategy (order types), Observer (price feed + portfolio), Composite (portfolio positions)

---

#### Expense Tracking / Splitwise
**Companies:** Splitwise, CRED, various fintech

**Core Requirements:**
- Groups, members, expenses
- Split: Equal, Exact, Percentage, Shares
- Simplify debts (minimize transactions)
- Settlement

**Classes to Design:**
```
SplitwiseSystem
├── User
├── Group → Member[]
├── Expense
│   └── ExpenseSplit (abstract)
│       ├── EqualSplit
│       ├── ExactSplit
│       ├── PercentageSplit
│       └── ShareSplit
├── Balance (who owes whom)
├── DebtSimplificationService
└── SettlementService
```

**Design Patterns:** Strategy (split types), Observer (payment reminders)

---

### 2.7 Social & Messaging

#### Social Media Platform (Twitter / Instagram)
**Companies:** Twitter/X, Instagram, Facebook/Meta, LinkedIn

**Core Requirements:**
- Post tweets / photos with text
- Follow / unfollow users
- News Feed (chronological / ranked)
- Like, Comment, Retweet
- Trending hashtags

**Classes to Design:**
```
SocialMediaPlatform
├── User → Profile
├── Post / Tweet
│   ├── Image, Video, Text
│   └── Hashtag[]
├── Follow relationship
├── FeedService (Observer: new posts from followed users)
│   └── FeedStrategy (Chronological / Ranked)
├── NotificationService (Observer)
├── TrendingService
└── SearchService
```

**Design Patterns:** Observer (feed updates), Strategy (feed ranking), Decorator (post types: image+video)

---

#### Messaging System (WhatsApp / Slack / Discord)
**Companies:** WhatsApp, Slack, Discord, Telegram, Microsoft Teams

**Core Requirements:**
- 1-on-1 and group chats
- Message delivery status: Sent → Delivered → Read
- Media sharing
- Online/offline status
- Encryption (conceptual)

**Classes to Design:**
```
MessagingSystem
├── User → OnlineStatus
├── Conversation (DirectChat / GroupChat)
│   └── Message[]
│       └── MessageStatus (SENT, DELIVERED, READ)
├── MessageService
├── GroupService
├── NotificationService (Observer)
└── MediaService
```

**Design Patterns:** Observer (message notifications, read receipts), State (message delivery status), Strategy (encryption)

---

#### LinkedIn
**Companies:** LinkedIn, Microsoft

**Core Requirements:**
- User profiles with work experience
- Connections (1st, 2nd, 3rd degree)
- Job listings, applications
- Recommendations, endorsements
- Feed of posts

**Classes to Design:**
```
LinkedInSystem
├── Profile (User, WorkExperience[], Education[], Skill[])
├── Connection → ConnectionStatus
├── JobListing → Application
├── Recommendation
├── Post / Feed
└── SearchService
```

---

#### Pub-Sub / Event Bus System
**Companies:** Google, Amazon, Confluent, various

**Core Requirements:**
- Topics, publishers, subscribers
- Message queue per subscriber
- At-least-once delivery

**Classes to Design:**
```
PubSubSystem
├── Topic
├── Publisher
├── Subscriber → MessageQueue
├── MessageBroker
└── Message
```

**Design Patterns:** Observer (pub-sub is observer at scale), Strategy (delivery guarantees)

---

#### Notification System
**Companies:** Facebook, Amazon, Google, Uber

**Core Requirements:**
- Channels: Email, SMS, Push, In-App
- Notification types: transactional, promotional
- User preference per channel
- Rate limiting (don't spam)
- Retry on failure

**Classes to Design:**
```
NotificationSystem
├── Notification → NotificationType
├── NotificationChannel (Strategy)
│   ├── EmailChannel
│   ├── SMSChannel
│   ├── PushChannel
│   └── InAppChannel
├── UserPreferenceService
├── RateLimiter
└── RetryService
```

**Design Patterns:** Strategy (channel), Observer (trigger events), Chain of Responsibility (retry), Template Method (notification format)

---

#### Dating App (Tinder)
**Companies:** Tinder, Bumble, Hinge

**Core Requirements:**
- Profile with photos + bio
- Swipe left (dislike) / right (like)
- Match when both like
- Chat on match
- Location-based filtering

**Classes to Design:**
```
DatingApp
├── UserProfile → Photo[], Bio, Location
├── SwipeService
│   └── Swipe (like / dislike)
├── MatchService
├── ConversationService (post-match)
└── RecommendationStrategy (nearest, common interests)
```

**Design Patterns:** Strategy (recommendation), Observer (match notification)

---

### 2.8 Streaming & Media

#### Video Streaming (Netflix / YouTube / Hotstar)
**Companies:** Netflix, YouTube, Amazon Prime, Hotstar, Twitch

**Core Requirements:**
- Content catalog (Movies, Series, Episodes)
- User profiles + watchlist
- Streaming + adaptive bitrate
- Recommendation engine
- Subscription plans

**Classes to Design:**
```
VideoStreamingSystem
├── Content (abstract) → Movie / Series → Episode[]
├── User → Profile[] → WatchHistory
├── Subscription → SubscriptionPlan
├── StreamingService
│   └── BitrateAdaptationStrategy
├── RecommendationEngine (Strategy)
│   ├── CollaborativeFiltering
│   └── ContentBasedFiltering
├── SearchService
└── DownloadService
```

**Design Patterns:** Strategy (recommendation, bitrate), Observer (new episode alerts), Decorator (subtitle overlay), Composite (Series → Seasons → Episodes)

---

#### Music Player (Spotify)
**Companies:** Spotify, Apple Music, Amazon Music, JioSaavn

**Core Requirements:**
- Songs, albums, playlists, podcasts
- Play, pause, skip, shuffle, repeat
- Offline downloads
- Recommendations

**Classes to Design:**
```
MusicPlayer
├── Song / Album / Playlist / Podcast
├── Queue (songs to play)
├── Player
│   └── PlayerState (PLAYING, PAUSED, STOPPED)
├── PlaybackStrategy (Sequential / Shuffle / Repeat)
├── DownloadService
└── RecommendationService
```

**Design Patterns:** State (player state), Strategy (playback mode + recommendation), Observer (song change events), Composite (Playlist → Songs)

---

#### Online Code Editor / Judge
**Companies:** HackerRank, LeetCode, Codeforces, Google (Docs analogue)

**Core Requirements:**
- Code editing with syntax highlighting
- Multi-language support
- Run code in sandbox
- Submit + judge (correct / wrong answer / TLE)
- Problem sets, contest management

**Classes to Design:**
```
OnlineJudge
├── Problem → TestCase[]
├── Submission → SubmissionStatus
├── CodeExecutor (Strategy per language)
│   ├── PythonExecutor
│   ├── JavaExecutor
│   └── CppExecutor
├── SandboxEnvironment
├── Judger
├── Contest → Leaderboard
└── UserProfile → Solved[]
```

**Design Patterns:** Strategy (language executor), State (submission status), Factory (executor per language)

---

#### Blogging Platform (Medium)
**Companies:** Medium, WordPress, Ghost, various

**Core Requirements:**
- Write, publish, draft, delete posts
- Tags, categories
- Comments, claps/likes
- Subscription (followers get notified)
- Paywalled content

**Classes to Design:**
```
BloggingPlatform
├── Author → Post[]
│   └── PostStatus (DRAFT, PUBLISHED, ARCHIVED)
├── Tag / Category
├── Comment
├── FollowService
└── NotificationService (Observer)
```

**Design Patterns:** State (Post status), Observer (follower notifications)

---

### 2.9 Infrastructure & Backend

#### LRU Cache
**Companies:** Google, Amazon, Facebook, Microsoft, Uber
*(LeetCode 146)*

**Core Requirements:**
- O(1) get and put
- Evict least recently used on capacity

**Classes to Design:**
```
LRUCache
├── Capacity
├── HashMap<key, DLinkedListNode>
└── DoublyLinkedList (head=MRU, tail=LRU)
    └── DLinkedListNode (key, value, prev, next)
```

**Design Pattern:** Combination of HashMap + Doubly Linked List

---

#### LFU Cache
**Companies:** Google, Facebook, Twitter
*(LeetCode 460)*

**Core Requirements:**
- O(1) get and put
- Evict least frequently used (ties broken by LRU)

**Classes to Design:**
```
LFUCache
├── HashMap<key, value>
├── HashMap<key, frequency>
├── HashMap<frequency, LinkedHashSet<key>>
└── minFrequency tracker
```

---

#### Rate Limiter
**Companies:** Twitter, Stripe, Cloudflare, Uber, GitHub

**Core Requirements:**
- Algorithms: Token Bucket, Leaky Bucket, Fixed Window, Sliding Window Log, Sliding Window Counter
- Per user / per IP / per API key
- Distributed rate limiting

**Classes to Design:**
```
RateLimiter (Strategy Pattern)
├── TokenBucketRateLimiter
├── LeakyBucketRateLimiter
├── FixedWindowRateLimiter
├── SlidingWindowLogRateLimiter
└── SlidingWindowCounterRateLimiter
```

**Design Patterns:** Strategy (algorithm), Singleton (per-service instance)

---

#### URL Shortener
**Companies:** Google (goo.gl), Bitly, Twitter (t.co), TinyURL

**Core Requirements:**
- Shorten long URL → short code
- Redirect short → long
- Analytics (click count, geo)
- Custom aliases
- Expiry

**Classes to Design:**
```
URLShortenerSystem
├── URLMapping (shortCode ↔ longURL, expiry)
├── ShortCodeGenerator (Strategy: Base62 / MD5-prefix / Custom)
├── RedirectService
├── AnalyticsService
└── CacheService (LRU for hot URLs)
```

**Design Patterns:** Strategy (code generation), Proxy (cache layer)

---

#### File System
**Companies:** Google (Drive), Dropbox, Amazon (S3), Microsoft (OneDrive)
*(LeetCode 1166)*

**Core Requirements:**
- Files and directories (Composite pattern naturally)
- Create, delete, move, copy
- Permissions (read, write, execute)
- File versioning

**Classes to Design:**
```
FileSystem
├── FileSystemEntry (abstract) ← Composite Pattern
│   ├── File (leaf)
│   └── Directory (composite, contains FileSystemEntry[])
├── Permission (owner, group, others)
├── VersionControl
└── FileSystemVisitor (Visitor Pattern for traversal)
```

**Design Patterns:** Composite (files + dirs), Visitor (traversal operations), Iterator (directory listing), Proxy (remote file access)

---

#### Logger System
**Companies:** All companies

**Core Requirements:**
- Log levels: DEBUG < INFO < WARN < ERROR < FATAL
- Multiple appenders: Console, File, Remote
- Async logging
- Log rotation

**Classes to Design:**
```
Logger (Singleton)
├── LogLevel (enum)
├── LogAppender (Strategy)
│   ├── ConsoleAppender
│   ├── FileAppender
│   └── RemoteAppender
├── LogFormatter (Strategy)
│   ├── JSONFormatter
│   └── PlainTextFormatter
└── LogFilter (Chain of Responsibility)
```

**Design Patterns:** Singleton (Logger), Strategy (appender + formatter), Chain of Responsibility (filters), Observer (async)

---

#### Connection Pool
**Companies:** All backend companies

**Core Requirements:**
- Maintain pool of reusable connections
- Acquire / release
- Max pool size, timeout

**Classes to Design:**
```
ConnectionPool (Singleton)
├── Connection[]
├── AvailableConnections (queue)
├── AcquireConnection()
└── ReleaseConnection()
```

**Design Patterns:** Singleton, Object Pool

---

#### Search Autocomplete System
**Companies:** Google, Amazon, Twitter
*(LeetCode 642)*

**Core Requirements:**
- Prefix-based suggestions
- Ranked by frequency/recency
- Real-time typing support

**Classes to Design:**
```
AutocompleteSystem
├── Trie (with frequency counts)
├── SearchHistoryService
└── SuggestionRanker (Strategy: Frequency / Recency / Personalized)
```

**Design Patterns:** Trie data structure, Strategy (ranking)

---

#### Pub-Sub Message Queue (Kafka-like)
**Companies:** LinkedIn, Confluent, various

**Core Requirements:**
- Topics + partitions
- Producer / Consumer groups
- Offset tracking
- At-least-once delivery

---

#### Underground / Metro System
**Companies:** Various transport companies
*(LeetCode 1396)*

**Core Requirements:**
- Station entry/exit with card tap
- Calculate average travel time between stations
- Fare calculation

---

### 2.10 Healthcare & Education

#### Hospital Management System
**Companies:** Practo, Epic, various healthcare

**Core Requirements:**
- Patient registration, medical records
- Doctor scheduling, appointment booking
- Billing (services + insurance)
- Pharmacy, lab results

**Classes to Design:**
```
HospitalManagementSystem
├── Patient → MedicalRecord[]
├── Doctor → Schedule[]
├── Appointment → AppointmentStatus
├── Department (Cardiology, Neurology, etc.)
├── BillingService
│   └── InsuranceCoverageStrategy
├── PharmacyService
└── LabService
```

**Design Patterns:** State (Appointment status), Strategy (billing/insurance), Observer (appointment reminders)

---

#### Learning Management System (LMS)
**Companies:** Coursera, Udemy, Byju's, Unacademy

**Core Requirements:**
- Courses → Sections → Lessons
- Enrollment, progress tracking
- Quizzes, assignments, grading
- Certificates

**Classes to Design:**
```
LMSSystem
├── Course → Section[] → Lesson[]
├── Student → Enrollment[] → Progress
├── Quiz → Question[]
├── Assignment → Submission → Grade
├── GradingStrategy (AutoGrade / ManualGrade)
└── CertificateService
```

**Design Patterns:** Composite (Course hierarchy), Strategy (grading), Observer (progress notifications)

---

#### Library Management System
**Companies:** Amazon, Microsoft, various

**Core Requirements:**
- Books, members, librarians
- Issue, return, renew books
- Reservations (book held for member)
- Fine calculation

**Classes to Design:**
```
LibraryManagementSystem
├── Library → BookShelf → BookItem
├── Book → BookItem[] (physical copies)
├── Member / Librarian (roles)
├── Lending → LendingStatus
├── Reservation
├── FineCalculationStrategy
└── SearchCatalogService
```

**Design Patterns:** Strategy (fine calculation), State (book item status), Observer (reservation availability)

---

### 2.11 Miscellaneous Systems

#### Smart Home System (Amazon Alexa / Google Home)
**Companies:** Amazon, Google, Apple

**Core Requirements:**
- Devices: Light, AC, Door, Camera, Speaker
- Control via voice / app
- Automation rules (if door opens → turn on lights)
- Scenes (Morning Scene: lights + AC + music)

**Classes to Design:**
```
SmartHomeSystem
├── SmartDevice (abstract)
│   ├── SmartLight
│   ├── SmartAC
│   ├── SmartDoor
│   └── SmartCamera
├── Command (Command Pattern)
│   ├── TurnOnCommand
│   └── TurnOffCommand
├── RemoteControl (Invoker)
├── AutomationRule (Condition + Action)
└── Scene (composite of commands)
```

**Design Patterns:** Command (device actions + undo), Observer (automation triggers), Composite (scenes), Strategy (voice vs app control)

---

#### Cricket Scoreboard
**Companies:** Indian IT companies, Dream11, Cricinfo

**Core Requirements:**
- Match (T20/ODI/Test), Teams, Players
- Ball-by-ball scoring
- Statistics (run rate, wickets, partnerships)
- Live update to display

**Classes to Design:**
```
CricketScoreboard
├── Match → Team × Team
│   └── Innings[]
│       └── Over[] → Ball[]
├── Player → BattingStats / BowlingStats
├── ScoreCalculator
└── DisplayBoard (Observer)
```

**Design Patterns:** Observer (live display updates)

---

#### Customer Support System (Zendesk)
**Companies:** Zendesk, Freshdesk, ServiceNow

**Core Requirements:**
- Ticket creation, assignment, escalation
- Priority levels, SLA tracking
- Agent assignment (round-robin / skill-based)
- Knowledge base

**Classes to Design:**
```
SupportSystem
├── Ticket → TicketStatus (OPEN, IN_PROGRESS, RESOLVED, CLOSED)
├── Agent → AgentSkill[]
├── TicketAssignmentStrategy (RoundRobin / SkillBased / Priority)
├── SLAService
├── EscalationService (Chain of Responsibility)
└── KnowledgeBase
```

**Design Patterns:** State (Ticket status), Strategy (assignment), Chain of Responsibility (escalation), Observer (SLA breach alerts)

---

#### Supply Chain Management
**Companies:** Amazon, Walmart, FedEx, DHL

**Core Requirements:**
- Supplier → Warehouse → Distribution → Retail
- Shipment tracking (real-time)
- Demand forecasting
- Returns management

---

#### Task Manager / To-Do App
**Companies:** Asana, Jira, Trello, Monday.com
*(LeetCode 2590)*

**Core Requirements:**
- Tasks, sub-tasks, tags, priority
- Assignees, due dates
- Project / board organization
- Comments, attachments

---

#### Text Editor
**Companies:** Google, Microsoft, Adobe
*(LeetCode 2296)*

**Core Requirements:**
- Insert, delete, undo, redo (Cursor position)
- Find and replace
- Syntax highlighting
- Multiple cursors (advanced)

**Classes to Design:**
```
TextEditor
├── Buffer (text content)
├── Cursor
├── Command (Command Pattern for undo/redo)
│   ├── InsertCommand
│   └── DeleteCommand
├── CommandHistory (Stack for undo/redo)
└── SyntaxHighlighter (Strategy per language)
```

**Design Patterns:** Command (undo/redo), Memento (save states), Strategy (syntax highlighting)

---

#### Coupon / Voucher System
**Companies:** All e-commerce, Zomato, Swiggy

**Core Requirements:**
- Coupon types: % off, flat off, free item, BOGO
- Usage limits, user limits, expiry
- Stacking rules
- Validation chain

**Design Patterns:** Strategy (coupon types), Chain of Responsibility (validation), Decorator (stacking discounts)

---

## 3. LeetCode Design Problems

> All LeetCode problems with a design/implementation component, grouped by pattern.

### Stack & Queue Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 155 | Min Stack | Medium | Amazon, Microsoft |
| 716 | Max Stack | Hard | Amazon |
| 232 | Implement Queue using Stacks | Easy | Amazon |
| 225 | Implement Stack using Queues | Easy | Microsoft |
| 622 | Design Circular Queue | Medium | Amazon |
| 641 | Design Circular Deque | Medium | Google |
| 1670 | Design Front Middle Back Queue | Medium | Google |
| 1381 | Design a Stack With Increment Operation | Medium | Amazon |
| 1172 | Dinner Plate Stacks | Hard | Google |

### Cache Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 146 | LRU Cache | Medium | Amazon, Google, Facebook, Microsoft, Uber |
| 460 | LFU Cache | Hard | Google, Facebook, Twitter |
| 1756 | Design Most Recently Used Queue | Medium | Amazon |

### Tree / Graph DS Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 173 | Binary Search Tree Iterator | Medium | Microsoft, Amazon |
| 919 | Complete Binary Tree Inserter | Medium | Google |
| 341 | Flatten Nested List Iterator | Medium | Google, Airbnb |
| 284 | Peeking Iterator | Medium | Google, Apple |
| 281 | Zigzag Iterator | Medium | Google, Facebook |
| 1286 | Iterator for Combination | Medium | LinkedIn |
| 900 | RLE Iterator | Medium | Google |
| 2642 | Design Graph With Shortest Path Calculator | Hard | Google |

### HashMap / HashSet Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 705 | Design HashSet | Easy | Amazon |
| 706 | Design HashMap | Easy | Amazon |
| 380 | Insert Delete GetRandom O(1) | Medium | Facebook, Amazon, Twitter |
| 381 | Insert Delete GetRandom O(1) - Duplicates | Hard | Facebook |
| 432 | All O'one Data Structure | Hard | Google |

### Stream / Online Algorithm Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 295 | Find Median from Data Stream | Hard | Amazon, Google, Facebook |
| 703 | Kth Largest Element in a Stream | Easy | Amazon |
| 933 | Number of Recent Calls | Easy | Facebook |
| 901 | Online Stock Span | Medium | Amazon, Google |
| 1352 | Product of the Last K Numbers | Medium | Amazon |
| 2034 | Stock Price Fluctuation | Medium | Amazon |
| 2102 | Sequentially Ordinal Rank Tracker | Hard | — |
| 2424 | Longest Uploaded Prefix | Medium | — |

### Range Query Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 307 | Range Sum Query - Mutable | Medium | Amazon |
| 308 | Range Sum Query 2D - Mutable | Hard | Google |
| 715 | Range Module | Hard | Google |
| 2080 | Range Frequency Queries | Medium | Google |
| 2276 | Count Integers in Intervals | Hard | Google |
| 2286 | Booking Concert Tickets in Groups | Hard | — |

### Calendar / Interval Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 729 | My Calendar I | Medium | Google, Amazon |
| 731 | My Calendar II | Medium | Google |
| 732 | My Calendar III | Hard | Google |

### File / String Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 588 | Design In-Memory File System | Hard | Dropbox, Google |
| 635 | Design Log Storage System | Medium | Palantir |
| 1166 | Design File System | Medium | Google, Amazon |
| 604 | Design Compressed String Iterator | Easy | LinkedIn |
| 2296 | Design a Text Editor | Hard | Google, Microsoft |
| 2349 | Design a Number Container System | Medium | — |

### Search / Autocomplete Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 208 | Implement Trie (Prefix Tree) | Medium | Google, Amazon, Facebook |
| 211 | Design Add and Search Words DS | Medium | Facebook |
| 642 | Design Search Autocomplete System | Hard | Google, Amazon |
| 1268 | Search Suggestions System | Medium | Amazon |

### Social / Business Logic Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 355 | Design Twitter | Medium | Twitter, Amazon |
| 1244 | Design A Leaderboard | Medium | Amazon, Epic Games |
| 1348 | Tweet Counts Per Frequency | Medium | Twitter |
| 1396 | Design Underground System | Medium | London Transport, Amazon |
| 2353 | Design a Food Rating System | Medium | Uber Eats, DoorDash |
| 2590 | Design a Todo List | Medium | Asana, Microsoft |

### System / Infrastructure Design

| # | Problem | Difficulty | Company |
|---|---------|------------|---------|
| 981 | Time Based Key-Value Store | Medium | Google, Amazon |
| 1472 | Design Browser History | Medium | Google, Amazon |
| 1797 | Design Authentication Manager | Medium | — |
| 2166 | Design Bitset | Medium | Facebook |
| 1656 | Design an Ordered Stream | Easy | — |
| 1603 | Design Parking System | Easy | Amazon |
| 2043 | Simple Bank System | Medium | Goldman Sachs |
| 2069 | Walking Robot Simulation II | Medium | Amazon |
| 2502 | Design Memory Allocator | Medium | — |
| 1622 | Fancy Sequence | Hard | — |
| 895 | Maximum Frequency Stack | Hard | Amazon, Google |
| 1206 | Design Skiplist | Hard | — |
| 1500 | Design a File Sharing System | Medium | — |
| 1570 | Dot Product of Two Sparse Vectors | Medium | Facebook |

---

## 4. Company-wise Questions

### Google

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Parking Lot | Singleton, Strategy, State, Factory |
| Elevator System | State, Strategy, Observer |
| Vending Machine | State, Chain of Responsibility, Strategy |
| Chess Game | Strategy, Command, Flyweight |
| Tic Tac Toe | Strategy, State |
| Snake Game | Deque, Simulation |
| LRU Cache (146) | HashMap + DLL |
| LFU Cache (460) | HashMap + HashMap of LinkedHashSets |
| File System (1166) | Composite, Visitor |
| Calendar System (729/731/732) | Interval tree, Segment Tree |
| Design Search Autocomplete (642) | Trie, Strategy |
| Log Storage System (635) | HashMap + Sorting |
| Range Module (715) | Segment Tree, Interval |
| Rate Limiter | Strategy (Token Bucket etc.) |
| Traffic Signal System | State, Observer |
| URL Shortener | Strategy (Base62), Proxy (cache) |
| Smart Home | Command, Observer, Composite |
| Design Graph (2642) | Dijkstra |

---

### Amazon

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Parking Lot | Singleton, Strategy, State |
| Online Shopping System | State, Strategy, Observer, Decorator |
| Movie Ticket Booking | State, Observer, Singleton |
| Inventory Management | Observer, Strategy |
| LRU Cache (146) | HashMap + DLL |
| Notification System | Observer, Strategy, Chain of Responsibility |
| Auction System | Strategy, State, Observer |
| Hotel Management | State, Strategy, Factory |
| Library Management | State, Strategy, Observer |
| Design Parking System (1603) | — |
| Find Median from Data Stream (295) | Two Heaps |
| Design Twitter (355) | Heap, HashMap |
| Design Search Autocomplete (642) | Trie |
| Design Browser History (1472) | Stack/DLL |
| Time Based Key-Value Store (981) | Binary Search + HashMap |
| Simple Bank System (2043) | HashMap |
| Max Stack (716) | Stack + Heap |
| Dinner Plate Stacks (1172) | Heap + Stack |

---

### Microsoft

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Parking Lot | Singleton, Strategy, State |
| Hotel Management | State, Strategy |
| Tic Tac Toe | Strategy, State |
| Snake and Ladders | Strategy, Observer |
| Text Editor (2296) | Command, Memento |
| Calendar System | Interval Tree |
| Task Manager | State, Observer, Composite |
| File System | Composite, Visitor |
| BST Iterator (173) | Stack-based inorder traversal |
| Min Stack (155) | Stack |

---

### Facebook / Meta

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Social Media (News Feed) | Observer, Strategy |
| Messaging System (WhatsApp-like) | State, Observer |
| Rate Limiter | Strategy (Sliding Window) |
| LRU Cache (146) | HashMap + DLL |
| LFU Cache (460) | Three HashMaps |
| Insert Delete GetRandom (380/381) | HashMap + Array |
| Find Median from Data Stream (295) | Two Heaps |
| Design Add and Search Words (211) | Trie |
| Notification System | Observer, Strategy |
| Chess Game | Strategy, Flyweight |

---

### Uber / Lyft

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Ride Sharing System | State, Strategy, Observer |
| Parking Lot | Singleton, Strategy, State |
| LRU Cache (146) | HashMap + DLL |
| Rate Limiter | Strategy |
| Notification System | Observer, Strategy |
| Driver Matching | Strategy (Dijkstra / Nearest) |
| Fare Calculation | Strategy (Surge Pricing) |

---

### Goldman Sachs / JP Morgan / Morgan Stanley

| Problem | Patterns / DSA Used |
|---------|-------------------|
| ATM Machine | State, Chain of Responsibility, Singleton |
| Banking System | Strategy, Template Method, Observer |
| Stock Trading System | Strategy, Observer, Heap (Order Book) |
| Simple Bank System (2043) | HashMap |
| Portfolio Management | Observer, Composite |
| Parking Lot | Singleton, Strategy |

---

### Twitter / X

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Twitter Feed (355) | Heap, HashMap |
| Rate Limiter | Strategy (Token Bucket, Sliding Window) |
| URL Shortener | Strategy (Base62) |
| Tweet Counts Per Frequency (1348) | HashMap + Sorted |
| Notification System | Observer |

---

### Flipkart / PayTM / Swiggy / Zomato

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Online Shopping System | State, Strategy, Observer, Decorator |
| Food Delivery System | State, Strategy, Observer |
| Movie Ticket Booking | State, Observer |
| Inventory Management | Observer, Strategy |
| Splitwise | Strategy |
| Digital Wallet | Strategy, Observer, State |
| Flash Sale System | Rate Limiting, Singleton |
| Discount/Coupon System | Strategy, Decorator, Chain of Responsibility |

---

### Netflix / Hotstar / Spotify

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Video Streaming Platform | Strategy, Observer, Composite, Decorator |
| Recommendation Engine | Strategy (Collaborative Filtering) |
| Music Player | State, Strategy, Observer, Composite |
| Subscription System | Strategy (plan types) |

---

### LinkedIn

| Problem | Patterns / DSA Used |
|---------|-------------------|
| LinkedIn System | Graph (BFS for connections), Observer |
| Job Portal | Strategy, Observer |
| Iterator for Combination (1286) | Iterator |
| Compressed String Iterator (604) | Iterator |

---

### Airbnb / Booking.com / Expedia

| Problem | Patterns / DSA Used |
|---------|-------------------|
| Hotel Management System | State, Strategy, Factory |
| Property Booking System | State, Observer, Strategy |
| Flatten Nested List Iterator (341) | Iterator, Stack |

---

### Dropbox / Google Drive

| Problem | Patterns / DSA Used |
|---------|-------------------|
| File System | Composite, Visitor, Iterator |
| In-Memory File System (588) | Composite, HashMap |
| File Sharing System (1500) | HashMap, Set |
| Design File System (1166) | HashMap, Trie |

---

## 5. Design Pattern → Problem Mapping

| Design Pattern | LLD Problems That Use It |
|----------------|--------------------------|
| **Singleton** | Parking Lot, ATM, Logger, Connection Pool, Vending Machine |
| **Factory Method** | Vehicle creation (Parking), Notification channel, Payment method |
| **Abstract Factory** | Smart Home device families, UI themes |
| **Builder** | Pizza Order, HTTP Request, User Profile creation |
| **Prototype** | Chess board clone, Game state copy |
| **Object Pool** | DB Connection Pool, Thread Pool |
| **Adapter** | Payment gateway integration, Third-party logger |
| **Bridge** | Notification (type × channel), Remote + device types |
| **Composite** | File System, Organization Hierarchy, Smart Home Scenes, Course → Lesson |
| **Decorator** | Pizza toppings, Shopping cart (price + tax + discount), Logging levels |
| **Facade** | Hotel booking (hides subsystems), ATM facade |
| **Flyweight** | Chess pieces, Text characters, Game particles |
| **Proxy** | Cache proxy (URL shortener), Security proxy, Virtual proxy |
| **Chain of Responsibility** | ATM denomination dispensing, Logging filters, Coupon validation, Escalation |
| **Command** | Text Editor undo/redo, Smart Home device control, Transaction rollback |
| **Iterator** | File traversal, Playlist navigation, BST Iterator |
| **Mediator** | Chat room, Air traffic control, Auction event coordination |
| **Memento** | Text Editor undo, Game save/load |
| **Observer** | Notification system, News feed, Order tracking, Stock price |
| **State** | Vending Machine, ATM, Elevator, Order status, Booking status, Traffic signal |
| **Strategy** | Payment methods, Pricing, Recommendation, Dispatch, Sorting, Rate limiting |
| **Template Method** | Report generation, Data export, Notification formatting |
| **Visitor** | AST evaluation, Tax calculation on order items |
| **Interpreter** | Calculator, Expression evaluator, SQL mini-parser |

---

## Quick Reference: What Interviewers Really Look For

```
1. Class diagram clarity
   - Identify entities (nouns) → classes
   - Identify behaviors (verbs) → methods
   - Identify relationships → association, aggregation, composition, inheritance

2. Applying the right design pattern
   - State machine problems → State Pattern
   - Multiple algorithms for same task → Strategy Pattern
   - One-instance globally → Singleton
   - Undo/Redo → Command + Memento
   - Event-driven / notification → Observer
   - Tree structures → Composite
   - Add behaviors without changing class → Decorator

3. SOLID Principles
   - S: Single Responsibility (one reason to change per class)
   - O: Open/Closed (open for extension, closed for modification)
   - L: Liskov Substitution (subtype must behave like parent)
   - I: Interface Segregation (small focused interfaces)
   - D: Dependency Inversion (depend on abstractions, not concretions)

4. Code quality signals
   - Enums over magic strings
   - Exception handling at boundaries
   - Thread safety (synchronized, locks) when mentioned
   - Extensibility comments ("to add new vehicle type, just extend Vehicle")
```
