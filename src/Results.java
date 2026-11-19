import java.util.Locale;

public class Results {
    private String functionName;
    private long duration;
    private String sample;

    public Results(String functionName, long duration, String sample) {
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public double getDurationMs() {
        return duration / 1_000_000.0;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%-36s | sample: %7s | tiempo: %10.4f ms",
                functionName, sample, getDurationMs());
    }
}