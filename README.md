# 🌐 Internationalization-i18n-with-Spring-Boot

This project demonstrates how to build a Spring Boot application that supports internationalization (i18n) — enabling dynamic language-based responses based on client locale preferences.

---

## 🚀 Features

- 🌍 Supports multiple languages (e.g., English, French, Hindi, etc.)
- 🔄 Dynamically changes response messages based on the user's `Accept-Language` header or query param
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

```
src/
├── config/
│   └── LocaleConfig.java        # Locale resolver, interceptor, message source
├── controller/
│   └── LocaleController.java    # i18n-enabled REST API endpoints
├── resources/
│   ├── messages.properties       # Default messages (English)
│   ├── messages_fr.properties    # French translations
│   ├── messages_hi.properties    # Hindi translations
│   └── application.properties
└── InternationalizationApplication.java
```

---

## 🌐 API Overview

### 🔹 Internationalized Greeting (Header-based)

**Endpoint:**
```
GET /greet
Header: Accept-Language: fr
```

**Example Response:**
```
Bonjour!
```

---

### 🔹 Greeting with Query Param (Param-based)

**Endpoint:**
```
GET /greet-lang?lang=hi
```

**Example Response:**
```
नमस्ते!
```

---

## ⚙️ How It Works

- `LocaleResolver` detects the user's preferred locale from either the `Accept-Language` header or query param.
- `MessageSource` loads the appropriate `messages_{locale}.properties` file based on the detected locale.
- The controller autowires `MessageSource` and serves locale-specific responses dynamically.

---

## 🧪 Testing via Postman or Curl

**Using Header:**
```http
GET http://localhost:8080/greet
Accept-Language: fr
```

**Using Query Parameter:**
```http
GET http://localhost:8080/greet-lang?lang=hi
```

---

## ✍️ Author

**Sakshi Sharma**  
Java Backend Developer  
