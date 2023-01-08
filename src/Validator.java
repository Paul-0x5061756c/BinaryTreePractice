public class Validator<E, A> {

    private String FunctionName;
    private E ExpectedValue;
    private A ActualValue;

    private String BooleanToReadAbleString(boolean bool){
        if(bool == true) return "✅ Success!: ";
        else return "❌ Failed!: ";
    }

    public void PrintValidation() {
        StringBuilder res = new StringBuilder();
        res.append(BooleanToReadAbleString(IsValid()));
        res.append(FunctionName);
        res.append(" ->");
        res.append(" Expected: ");
        res.append(ExpectedValue);
        res.append(" - Result: ");
        res.append(ActualValue);
        System.out.println(res.toString());
    }

    public boolean IsValid() {
        if (ExpectedValue instanceof String && ActualValue instanceof String) {
            return ExpectedValue.equals(ActualValue);
        }
        return ExpectedValue == ActualValue;
    }

    ;


    Validator(String functionName, E expectedValue, A actualValue) {
        this.FunctionName = functionName;
        this.ExpectedValue = expectedValue;
        this.ActualValue = actualValue;
    }
}
