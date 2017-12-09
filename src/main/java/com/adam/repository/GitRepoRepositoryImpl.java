package com.adam.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.adam.common.util.RestURLConstants;
import com.adam.exception.AppException;
import com.adam.exception.ErrorCode;
import com.adam.rest.processor.IRestServiceProcessor;
import com.git.repo.commits.GitRepoCommits;
import com.git.repo.commits.GitRepoResponse;

/**
 * Git Repo Repository class
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@Repository
public class GitRepoRepositoryImpl implements IGitRepoRepository {

	@Autowired
	IRestServiceProcessor restProcessor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adam.repository.IGitRepoRepository#getLatestCommits()
	 */
	@Override
	public GitRepoResponse getLatestCommits() throws AppException {

		ResponseEntity<GitRepoCommits[]> response = restProcessor.execute(RestURLConstants.VENDOR_URL,
				GitRepoCommits[].class);

		if (response != null) {
			GitRepoCommits[] body = response.getBody();

			GitRepoResponse contentResponse = new GitRepoResponse();
			contentResponse.setResp(Arrays.asList(body).subList(0, 25));

			return contentResponse;
		} else {
			throw new AppException(ErrorCode.ERR_WHILE_CALLING, ErrorCode.ERR_WHILE_CALLING.getMessage());
		}

	}

}
