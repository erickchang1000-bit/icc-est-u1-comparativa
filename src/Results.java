public class Results {
    private String functionName;
    private Long duration;
    private String sample;
    public Results(String functionName, Long duration, String sample) {
        this.functionName = functionName;
        this.duration = duration;
        this.sample = sample;
    }
    public String getFunctionName() {
        return functionName;
    }
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    public Long getDuration() {
        return duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    public String getSample() {
        return sample;
    }
    public void setSample(String sample) {
        this.sample = sample;
    }
    @Override
    public String toString() {
        double segundos = duration /1_000_000_000.0;
        return "Results [functionName=" + functionName + ", duration=" + duration + ", sample=" + sample + "]";
    }
    
}
