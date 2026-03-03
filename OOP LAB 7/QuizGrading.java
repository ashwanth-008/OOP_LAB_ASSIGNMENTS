enum Result {
    CORRECT, WRONG, UNANSWERED
}

class QuizGrading {

    public static void main(String[] args) {

        // Correct answers
        char[] correctAnswers = {'C', 'A', 'B', 'D'};

        int correct = 0;
        int wrong = 0;

        System.out.println("QUESTION  SUBMITTED  CORRECT  RESULT");

        // Loop through questions
        for (int i = 0; i < correctAnswers.length; i++) {

            // If answer provided, take first char, else X
            char submitted = (args.length > i) ? args[i].toUpperCase().charAt(0) : 'X';

            Result result;

            if (submitted == 'X') {
                result = Result.UNANSWERED;
            } else if (submitted == correctAnswers[i]) {
                result = Result.CORRECT;
                correct++;
            } else {
                result = Result.WRONG;
                wrong++;
            }

            System.out.printf("%d         %c          %c        %s%n", 
                              (i + 1), submitted, correctAnswers[i], result);
        }

        // Display summary
        System.out.println("\nNo. of correct answers: " + correct);
        System.out.println("No. of wrong answers: " + wrong);

        if (correct >= 2) {
            System.out.println("Candidate passed.");
        } else {
            System.out.println("Candidate failed.");
        }
    }
}
