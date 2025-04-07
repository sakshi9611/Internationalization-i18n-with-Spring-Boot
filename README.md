# 🌐 Internationalization-i18n-with-Spring-Boot

This project demonstrates how to build a Spring Boot application that supports internationalization (i18n) — enabling dynamic language-based responses based on client locale preferences.
---
## 🚀 Features

- 🌍 Supports multiple languages (e.g., English, French, etc.)
- 🔄 Dynamically changes response messages based on the user's `Accept-Language` header
- 🛠️ Easy-to-extend with additional locale files (`messages_xx.properties`)
- ✅ Simple REST API to test internationalized messages
---
## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Spring MVC**
- **ResourceBundleMessageSource**
- **LocaleResolver**
---
## 🧩 Project Structure
src/
├── config/
│   └── LocaleConfig.java      # Locale resolver, interceptor, message source
├── controller/
│   └── GreetingController.java # Simple i18n-enabled REST API
├── resources/
│   ├── messages.properties     # Default messages (English)
│   ├── messages_fr.properties  # French translations
│   ├── messages_hi.properties  # Hindi translations
│   └── application.properties
└── InternationalizationApplication.java

## 🌐 API Overview

### 🔹 Internationalized Greeting

**API Endpoint:**
Greeting APIs
🔸 Based on HTTP Header
GET /greet
Header: Accept-Language: fr
🔸 Based on Query Param
GET /greet-lang?lang=de
---
## ⚙️ How It Works

- `LocaleResolver` detects user locale from the HTTP header
- `MessageSource` loads the corresponding `messages_{locale}.properties` file
- The controller uses `@Autowired MessageSource` to return the right translation
---
## 🧪 Test in Postman or Curl
GET http://localhost:8080/greet
Accept-Language: fr
Returns:
Bonjour!

Author
Sakshi Sharma
Java Backend Developer
