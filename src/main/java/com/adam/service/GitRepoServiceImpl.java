package com.adam.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adam.exception.AppException;
import com.adam.repository.IGitRepoRepository;
import com.git.repo.commits.GitRepoCommits;
import com.git.repo.commits.GitRepoResponse;

/**
 * Git Repo service class
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@Service
public class GitRepoServiceImpl implements IGitRepoService {

	@Autowired
	IGitRepoRepository gitRepository;

	@Override
	public GitRepoResponse getLatestCommits() throws AppException {
		GitRepoResponse response = gitRepository.getLatestCommits();
		processResponse(response);
		return response;
	}

	private void processResponse(GitRepoResponse response) {
		if (response != null) {
			for (GitRepoCommits commit : response.getResp()) {
				// Update with GMT Time differences to display on UI
				String commitDateString = commit.getCommit().getCommitter().getDate();
				Date commitedDate = new Date();
				try {
					commitedDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
							.parse(commitDateString.replaceAll("T", " ").replaceAll("Z", ""));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				long presetTimeInMillis = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();

				long diffInHours = (presetTimeInMillis - commitedDate.getTime()) / (60 * 60 * 1000);
				long diffInMinutes = (presetTimeInMillis - commitedDate.getTime()) / (60 * 1000);
				if (diffInHours > 0) {
					commit.getCommit().getCommitter().setDate("Comitted " + diffInHours + " Hours ago");
				} else {
					commit.getCommit().getCommitter().setDate("Comitted " + diffInMinutes + " Minutes ago");
				}

			}
		}
	}

}
