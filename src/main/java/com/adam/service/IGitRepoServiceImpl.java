package com.adam.service;

import com.adam.exception.AppException;
import com.git.repo.commits.GitRepoResponse;

/**
 * Git Repo Service interface
 * @author Chandra Sekhar Babu A
 *
 */
public interface IGitRepoServiceImpl {

	public GitRepoResponse getLatestCommits() throws AppException;
}
