package lab.QuestionInheritance;

public class NumberRangeQA extends QA {
    private int intAnswer;
    private int range;
    private int lBound;
    private int uBound;

    public NumberRangeQA(String q, String a, int range) {
        super(q, a);
        intAnswer = Integer.parseInt(a);
        this.range = range;
        lBound = intAnswer - range;
        uBound = intAnswer + range;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return (Integer.parseInt(userAnswer) >= lBound) && (Integer.parseInt(userAnswer) <= uBound);
    }

    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("(between " + lBound + " - " + uBound + ")");
    }
}
