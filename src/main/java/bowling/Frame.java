package bowling;

public class Frame {
    private String frameString;
    private Integer frameNumber;
    private Integer frameScore;
    private Integer frameRunningTotal;
    
	public Integer getFrameRunningTotal() {
		return frameRunningTotal;
	}
	public void setFrameRunningTotal(Integer frameRunningTotal) {
		this.frameRunningTotal = frameRunningTotal;
	}
	public String getFrameString() {
		return frameString;
	}
	public void setFrameString(String frameString) {
		this.frameString = frameString;
	}
	public Integer getFrameNumber() {
		return frameNumber;
	}
	public void setFrameNumber(Integer frameNumber) {
		this.frameNumber = frameNumber;
	}
	public Integer getFrameScore() {
		return frameScore;
	}
	public void setFrameScore(Integer frameScore) {
		this.frameScore = frameScore;
	}
}
