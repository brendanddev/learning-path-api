#!/bin/bash

# A simple script to test the endpoints of the Learning Path API

BASE_URL="http://localhost:8080/api"

# Get all users
echo "Testing GET /users"
USER_RESPONSE=$(curl -s -X GET "$BASE_URL/users")
echo "Get Response:"
echo "$USER_RESPONSE"

# Create a new user
echo "Testing POST /users"
echo "Creating a new user..."
USER_RESPONSE=$(curl -s -X POST "${BASE_URL}/users" \
    -H "Content-Type: application/json" \
    -d '{"name": "Admin","email":"admin@admin.com"}')

echo "User Created Response:"
echo "$USER_RESPONSE"

# Extract user id
USER_ID=$(echo "$USER_RESPONSE" | grep -o '"id":[0-9]*' | head -1 | grep -o '[0-9]*')
echo "User ID is $USER_ID"

# Get user by ID
echo "Testing GET /users/$USER_ID"
USER_RESPONSE=$(curl -s -X GET "$BASE_URL/users/$USER_ID")
echo "Get User by ID Response:"
echo "$USER_RESPONSE"

# Create a new skill
echo "Testing POST /skills"
SKILL_RESPONSE=$(curl -s -X POST "${BASE_URL}/skills" \
    -H "Content-Type: application/json" \
    -d '{"name": "Java"}')

echo "Skill Created Response:"
echo "$SKILL_RESPONSE"

# Extract skill name
SKILL_NAME=$(echo "$SKILL_RESPONSE" | grep -o '"name":"[^"]*"' | head -1 | sed 's/"name":"\([^"]*\)"/\1/')
echo "Skill Name is $SKILL_NAME"

echo "Skill Name before sending: [$SKILL_NAME]"

# Add skill to user
echo "Testing POST /users/$USER_ID/skills"
ADD_SKILL_RESPONSE=$(curl -s -X POST "${BASE_URL}/users/$USER_ID/skills" \
    -H "Content-Type: application/json" \
    -d "\"$SKILL_NAME\"")

echo "Add Skill to User Response:"
echo "$ADD_SKILL_RESPONSE"