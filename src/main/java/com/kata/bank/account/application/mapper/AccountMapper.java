package com.kata.bank.account.application.mapper;

import com.kata.bank.account.application.response.StatementResponse;
import com.kata.bank.account.domain.Statement;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {
    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public static StatementResponse mapToStatementResponse(Statement statement) {
        return modelMapper.map(statement, StatementResponse.class);
    }

    public static List<StatementResponse> mapToStatementResponses(List<Statement> statements) {
        return statements.stream().map(AccountMapper::mapToStatementResponse).collect(Collectors.toList());
    }
}
