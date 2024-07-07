package com.dowe.auth.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dowe.auth.application.AuthService;
import com.dowe.auth.dto.LoginData;
import com.dowe.member.Provider;
import com.dowe.util.api.ApiResponse;
import com.dowe.util.api.ResponseResult;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@GetMapping("/oauth/{provider}")
	public ResponseEntity<ApiResponse<LoginData>> login(@PathVariable Provider provider, @RequestParam String authorizationCode) {
		return ResponseEntity.ok()
			.body(ApiResponse.ok(ResponseResult.LOGIN_SUCCESS, authService.login(provider, authorizationCode)));
	}

}