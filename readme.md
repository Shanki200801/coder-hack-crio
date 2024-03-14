## Problem Statement

#### Develop a RESTful API service using Spring Boot to manage the Leaderboard for a Coding Platform while using MongoDB to persist the data.

## Problem Description

#### While coding platforms usually host multiple contests while maintaining numerous leaderboards, this assignment requires you to design a service for managing the leaderboard of a specific contest. Assume the platform has only one contest with a single leaderboard. The platform also gives virtual awards to the users called Badges based on their score.

## Requirements

1. The API must handle CRUD operations for competing user registrations
2. Each user has the following fields:
   a. User ID (Unique Identifier)
   b. Username
   c. Score (0 <= Score <= 100)
   d. Badges (Code Ninja, Code Champ, Code Master)
3. User registration requests must have a User ID and Username
4. The score must be 0, and the badges must be empty initially after the registration
5. Updation through PUT requests is only allowed for Score
6. Badges must be awarded based on the score:
   1 <= Score <= 30 -> Code Ninja
   30 <= Score <= 60 -> Code Champ
   60 <= Score <= 100 -> Code Master
7. A user can only have a maximum of three unique badges
   {Code Ninja, Code Champ, Code Master} -> Valid
   {Code Ninja} -> Valid
   {Code Ninja, Code Champ, Code Master, Code Ninja} -> Invalid
8. User retrieval must be sorted based on the score
9. Sorting should have the time complexity of O(nlogn)
10. Include basic JUnit test cases to verify the operations
11. Validation and Error Handling
12. Add basic validation for all fields (Ex. Score > 0)
13. Handle common errors and return appropriate HTTP codes (Ex. 404, User not found)

## Endpoints

        1. GET /users - Retrieve a list of all registered users
        2. GET /users/{userId} - Retrieve the details of a specific user
        3. POST /users - Register a new user to the contest
        4. PUT /users/{userId} - Update the score of a specific user
        5. DELETE /users/{userId} - Deregister a specific user from the contest
