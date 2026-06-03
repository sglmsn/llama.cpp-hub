package org.mark.llamacpp.server.struct;

public class TokenSummaryEntry {
	private String modelId;
	private long totalCacheTokens;
	private long totalPromptTokens;
	private long totalPredictedTokens;
	private long totalTokens;
	private double totalPromptMs;
	private double totalPredictedMs;
	private long totalDraftTokens;
	private long totalDraftAccepted;
	private float maxPredictedPerSecond;
	private float maxPromptPerSecond;
	private double totalPredictedPerSecond;
	private double totalPromptPerSecond;
	private long recordCount;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public long getTotalCacheTokens() {
		return totalCacheTokens;
	}

	public void setTotalCacheTokens(long totalCacheTokens) {
		this.totalCacheTokens = totalCacheTokens;
	}

	public long getTotalPromptTokens() {
		return totalPromptTokens;
	}

	public void setTotalPromptTokens(long totalPromptTokens) {
		this.totalPromptTokens = totalPromptTokens;
	}

	public long getTotalPredictedTokens() {
		return totalPredictedTokens;
	}

	public void setTotalPredictedTokens(long totalPredictedTokens) {
		this.totalPredictedTokens = totalPredictedTokens;
	}

	public long getTotalTokens() {
		return totalTokens;
	}

	public void setTotalTokens(long totalTokens) {
		this.totalTokens = totalTokens;
	}

	public double getTotalPromptMs() {
		return totalPromptMs;
	}

	public void setTotalPromptMs(double totalPromptMs) {
		this.totalPromptMs = totalPromptMs;
	}

	public double getTotalPredictedMs() {
		return totalPredictedMs;
	}

	public void setTotalPredictedMs(double totalPredictedMs) {
		this.totalPredictedMs = totalPredictedMs;
	}

	public long getTotalDraftTokens() {
		return totalDraftTokens;
	}

	public void setTotalDraftTokens(long totalDraftTokens) {
		this.totalDraftTokens = totalDraftTokens;
	}

	public long getTotalDraftAccepted() {
		return totalDraftAccepted;
	}

 public void setTotalDraftAccepted(long totalDraftAccepted) {
        this.totalDraftAccepted = totalDraftAccepted;
    }

    public float getMaxPredictedPerSecond() {
        return maxPredictedPerSecond;
    }

    public void setMaxPredictedPerSecond(float maxPredictedPerSecond) {
        this.maxPredictedPerSecond = maxPredictedPerSecond;
    }

    public float getMaxPromptPerSecond() {
        return maxPromptPerSecond;
    }

    public void setMaxPromptPerSecond(float maxPromptPerSecond) {
        this.maxPromptPerSecond = maxPromptPerSecond;
    }

    public double getTotalPredictedPerSecond() {
        return totalPredictedPerSecond;
    }

    public void setTotalPredictedPerSecond(double totalPredictedPerSecond) {
        this.totalPredictedPerSecond = totalPredictedPerSecond;
    }

    public double getTotalPromptPerSecond() {
        return totalPromptPerSecond;
    }

    public void setTotalPromptPerSecond(double totalPromptPerSecond) {
        this.totalPromptPerSecond = totalPromptPerSecond;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public double getAveragePredictedPerSecond() {
        return recordCount > 0 ? totalPredictedPerSecond / recordCount : 0;
    }

    public double getAveragePromptPerSecond() {
        return recordCount > 0 ? totalPromptPerSecond / recordCount : 0;
    }
}
