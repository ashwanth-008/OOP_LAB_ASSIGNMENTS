enum Result {
    CORRECT, WRONG, UNANSWERED
}  //meaning the variable created using Result can only have these three values
public class QuizGrader {
    public static void main(String[] args) {
        char[] correctAnswers = {'C','A','B','D','B','C','C','A'};
        int correct = 0, wrong = 0, unanswered = 0;
        System.out.println("QUESTION SUBMITTED CORRECT RESULT");
        for (int i = 0; i < correctAnswers.length; i++) {
            char submitted = args[i].charAt(0);
            Result result;
            if (submitted == 'X') {
                result = Result.UNANSWERED;
                unanswered++;
            } else if (submitted == correctAnswers[i]) {
                result = Result.CORRECT;
                correct++;
            } else {
                result = Result.WRONG;
                wrong++;
            }
            System.out.println((i+1) + "        " + submitted +
                    "         " + correctAnswers[i] +
                    "       " + result);
        }
        System.out.println("\nCorrectly answered: " + correct);
        System.out.println("Wrong answers: " + wrong);
        System.out.println("Questions unanswered: " + unanswered);
    }
}
