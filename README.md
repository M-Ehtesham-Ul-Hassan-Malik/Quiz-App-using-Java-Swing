# Quiz App

Quiz App is a Java-based desktop application that allows users to participate in a quiz. The application guides the user from a login screen through the quiz, displaying questions one at a time, and finally presenting the user's score at the end.

## Table of Contents

- [Features](#features)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- User-friendly interface
- Timer for each question
- Display of rules before starting the quiz
- A variety of multiple-choice questions
- Score display at the end

## Installation

To run this project locally, follow these steps:

1. **Clone the repository**:

    ```sh
    git clone https://github.com/M-Ehtesham-Ul-Hassan-Malik/Quiz-App-using-Java-Swing.git
    ```

2. **Navigate to the project directory**:

    ```sh
    cd scr/quizApp
    ```

3. **Compile the project**:

    ```sh
    javac -d bin -sourcepath src src/quizApp/*.java
    ```

4. **Run the project**:

    ```sh
    java -cp bin quizApp.Login
    ```

## Usage

1. **Login**: Enter your name on the login screen and click "Next".
2. **Read Rules**: Read the quiz rules and click "Start" to begin the quiz.
3. **Answer Questions**: Answer each question within the allotted time. Use the "Next" button to proceed to the next question.
4. **View Score**: After the quiz ends, view your score on the final screen.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -m 'Add some new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
