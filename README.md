# ChatWalk Forge

This is a Forge port of the Fabric mod [ChatWalk](https://modrinth.com/mod/chatwalk) by CodeF53. It allows players to continue moving forward while the chat screen is open, making it easier to coordinate with others without stopping.

This port not only brings the original functionality to Forge but also adds a new quality-of-life feature for players moving in water.

## Features

- **Walk While Chatting**: If you open the chat screen while holding your forward key, you will continue to walk forward automatically.
- **Float While Chatting**: As an added feature, if you are in water (but not swimming underwater) when you activate ChatWalk, you will also automatically jump. This keeps you afloat at the water's surface while you type.
- **Auto Jump While Chatting**: If Minecraft’s built-in auto-jump is disabled and you are walking while chatting you will also automatically jump over jumpable blocks.
- You can disable auto jump for this mod and ChatWalk altogether by going inside your modlist and clicking the config button.

## How to Use

1.  Start moving forward by holding your "forward" key (usually `W`).
2.  While still holding the forward key, press your "chat" key (usually `T`).
3.  You will continue moving forward automatically, even after releasing the forward key. You can now type in chat.
4.  The auto-walking will stop as soon as you close the chat screen.

## Build from Source

To build the mod from the source code, follow these steps:

1.  Clone the repository.
2.  Open a terminal or command prompt in the project's root directory (`ChatWalkForge/`).
3.  Run the following Gradle command:
    ```sh
    ./gradlew build
    ```
4.  The compiled mod JAR file will be located in the `build/libs/` directory.

## Credits
-   **CodeF53**: For creating the original [ChatWalk](https://modrinth.com/mod/chatwalk) (Fabric) mod.
