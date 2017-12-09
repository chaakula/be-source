package com.adam.repository;

import com.adam.exception.AppException;
import com.git.repo.commits.GitRepoResponse;

/**
 * Repo Repository Interface
 * @author Chandra Sekhar Babu A
 *
 */
public interface IGitRepoRepository {

	public GitRepoResponse getLatestCommits() throws AppException;
}
