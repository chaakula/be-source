package com.adam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adam.exception.AppException;
import com.adam.repository.IGitRepoRepository;
import com.git.repo.commits.GitRepoResponse;

/**
 * Git Repo service class
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@Service
public class GitRepoService implements IGitRepoServiceImpl {

	@Autowired
	IGitRepoRepository gitRepository;

	@Override
	public GitRepoResponse getLatestCommits() throws AppException {
		GitRepoResponse response = gitRepository.getLatestCommits();
		return response;
	}

}
