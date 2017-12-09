package com.adam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adam.common.util.RestURLConstants;
import com.adam.exception.AppException;
import com.adam.response.viewmodel.AppResponse;
import com.adam.service.IGitRepoService;
import com.git.repo.commits.GitRepoResponse;

/**
 * Rest controller to the application
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@RestController
public class GitRepoController {

	@Autowired
	IGitRepoService gitRepoService;

	/**
	 * 
	 * @param filter
	 * @param level
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = RestURLConstants.COMMITS_REST_URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppResponse getLatestCommits() throws AppException {
		System.out.println("Received");
		// Service call
		GitRepoResponse resp = gitRepoService.getLatestCommits();

		// Prepare Response
		AppResponse response = new AppResponse();
		response.setResponseViewModel(resp);

		return response;
	}

}
