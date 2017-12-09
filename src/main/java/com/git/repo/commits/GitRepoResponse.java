package com.git.repo.commits;

import java.util.ArrayList;
import java.util.List;

public class GitRepoResponse {

	List<GitRepoCommits> resp = new ArrayList<>();

	public List<GitRepoCommits> getResp() {
		return resp;
	}

	public void setResp(List<GitRepoCommits> resp) {
		this.resp = resp;
	}
	
}
