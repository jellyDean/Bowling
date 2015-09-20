package bowling;

public class GameOutput {
    private Integer score;
	private Integer code;
    private String message;
    private Integer turkeys;
    int[] frameScores = new int[10];
    
    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getTurkeys() {
		return turkeys;
	}

	public void setTurkeys(Integer turkeys) {
		this.turkeys = turkeys;
	}

	public int[] getFrameScores() {
		return frameScores;
	}

	public void setFrameScores(int[] frameScores) {
		this.frameScores = frameScores;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
   
}