package xyz.cymedical.entity.xin;

public class Summarize {
	private int summarize_id;	//总结id
	private String advise;		//建议
	private	String guide;		//建议
	
	public Summarize() {
		super();
	}

	public Summarize(String advise, String guide) {
		super();
		this.advise = advise;
		this.guide = guide;
	}

	public Summarize(int summarize_id, String advise, String guide) {
		super();
		this.summarize_id = summarize_id;
		this.advise = advise;
		this.guide = guide;
	}

	public int getSummarize_id() {
		return summarize_id;
	}

	public void setSummarize_id(int summarize_id) {
		this.summarize_id = summarize_id;
	}

	public String getAdvise() {
		return advise;
	}

	public void setAdvise(String advise) {
		this.advise = advise;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	@Override
	public String toString() {
		return "Summarize [summarize_id=" + summarize_id + ", advise=" + advise + ", guide=" + guide + "]";
	}

	
	
}
