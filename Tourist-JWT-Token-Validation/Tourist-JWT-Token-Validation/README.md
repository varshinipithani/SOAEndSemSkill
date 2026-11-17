# Tourist JWT Token Validation

A Spring Boot REST API demo. JWT authentication protects the tourist endpoints.

## Requirements
- Java 17
- Maven 3.6+ (or import as an Existing Maven Project in Spring Tool Suite)
- Internet connection for the first Maven dependency download

## Import into Spring Tool Suite (STS)
1. Extract this ZIP file.
2. Open STS.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Browse to the extracted `Tourist-JWT-Token-Validation` folder.
5. Select `pom.xml`, then click **Finish**.
6. Wait for Maven dependencies to download.
7. Run `TouristJwtProjectApplication.java` using **Run As → Spring Boot App**.

The app runs at `http://localhost:8080`.

## Demo login
`POST http://localhost:8080/api/auth/token`

Header: `Content-Type: application/json`

Body:
```json
{
  "username": "admin",
  "password": "1234"
}
```

Copy the `token` value from the response.

## Protected endpoints
For every endpoint below, add this header:

`Authorization: Bearer YOUR_COPIED_TOKEN`

| Method | URL | Purpose |
|---|---|---|
| GET | `/api/auth/verify` | Verify token |
| GET | `/api/tourists` | Fetch all tourists |
| GET | `/api/tourists/1` | Fetch tourist by ID |
| POST | `/api/tourists` | Add a tourist |

Example POST body:
```json
{
  "name": "Kiran",
  "destination": "Araku Valley",
  "country": "India"
}
```

Without a token, or with an invalid/expired token, protected endpoints return HTTP `401 Unauthorized`.

## GitHub push
Create an empty repository on GitHub. Then open a terminal in this extracted project folder and run:

```bash
git init
git add .
git commit -m "Initial Tourist JWT project"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
git push -u origin main
```

Replace the URL with your own GitHub repository URL. If Git says `remote origin already exists`, run:
`git remote set-url origin https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git`

## Important notes
- Tourist records are stored in memory. They reset when the application restarts; no database is configured in this quick demo.
- Demo credentials are hardcoded and are not suitable for production.
- The JWT signing secret in `application.properties` is for local demonstration only. For a real deployment, use a newly generated secret stored in an environment variable or secret manager, and do not commit it to GitHub.
- Maven dependencies are declared in `pom.xml` and are downloaded by Maven during the first build. They are not bundled as JAR files in this ZIP.
