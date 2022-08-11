<h1 align="center">
    CODE SHARING PLATFORM
</h1>

___

## 🚀 **Description**

Sometimes, it's useful to have a tool that can help you share a piece of code with other programmers. Actually, there is a website called Pastebin that does exactly that. A huge downside of Pastebin is that every piece of code you share automatically becomes available for the public. This could present a problem since many programmers work under the NDA (Non-disclosure agreement) which prohibits the use of such services to prevent the source code from leaking.

If there is a team of programmers who work in the same company and want to exchange pieces of code, they can solve this problem by using their own implementation of Pastebin. Such is `Code Sharing Platform`.

<br>

https://user-images.githubusercontent.com/70847388/184181977-bf4d5551-2875-4675-9a1a-dfb81d78102e.mp4

###### *For detailed information, refer to the [**JetBrains Academy**](https://hyperskill.org/projects/180?track=12).*

___

## 🔬 **Examples**

### **Example 1:**

Request `POST /api/code/new` with the following body:

```json
{ "code": "class Code { ..." }
```

Response: `{ "id" : "1" }`.

Another request `POST /api/code/new` with the following body:

```json
{ "code": "public static void ..." }
```

Response: `{ "id" : "2" }`.

<br>

### **Example 2:**

Request: `GET /api/code/1`

Response:

```json
{
    "code": "class Code { ...",
    "date": "2022-08-11 22:32:20"
}
```

<br>

### **Example 3:**

Request: `GET /api/code/2`

Response:

```json
{
    "code": "public static void ...",
    "date": "2022-08-11 22:33:19"
}
```

<br>

### **Example 4:**

Request: `GET /api/code/latest`

Response:

```json
[
    {
        "code": "public static void ...",
        "date": "2022-08-11 22:33:19"
    },
    {
        "code": "class Code { ...",
        "date": "2022-08-11 22:32:20"
    }
]
```

<br>

### **Example 5:**

Request: `GET /code/latest`

Response:

![latest](https://user-images.githubusercontent.com/70847388/184197421-cd59e162-be73-4e00-b65f-0e098e0510b7.png)

