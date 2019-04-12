Author: Steele Desmond - sdesmondemail@gmail.com
# Chat Room / Tuple Space Implementation

## Versions (Jar files)

Version 1.0 - Assignment requirements implementation

## Overview

This repository includes a tuple space implementation in java and a chat room to
demonstrate usage of the tuple space. The chat room is simple to use and is
console based. In the implementation, the only active user is the user that is 
currently being used.

## How to use the chat room

Possible Commands:

'(cu)current user' -- Check which user you are currently logged in as

'(s)switch user' -- Switch to a different user. Enter the username of the user

'(m)get recent messages' -- Retrieve the last 10 messages posted in the chat room

'(a)get active users' -- Get a list of active users in the chat room

'(all)get all users' -- Get a list of all users in the chat room

'(pm)post message' -- Post a new message as the current user

'(nu)new user' -- Create a new user and log in as them

'(t)testing mode' -- Call the tuple space test classes

## Implemented Features

There is a simple tuple space, a more efficient tuple space, and a chat room that
uses the tuple space.

## Testing and Debugging

There are tests for correctness and efficiency in the TupleSpaceTest class.
When the chat room is ran, use the command (t) to run the tests.

##### See docs for design and more class descriptions
