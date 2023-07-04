package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import DTO.AccountInfoDTO;
import DTO.AccountTransferInfoDTO;
import service.AccountServiceImpl;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AccountRepository;
import repository.AccountRepositoryImpl;
import service.AccountService;


/**
 * Servlet implementation class AccountController
 */
@WebServlet("/account")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    
    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();
        // JSON 요청 데이터 이체(거래)
        AccountTransferInfoDTO transferInfo = gson.fromJson(reader, AccountTransferInfoDTO.class);

        // 출금 계좌 정보 조회
        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountInfoDTO fromAccount = accountRepository.getAccount(transferInfo.getAccountNumber1());
        // 입금 계좌 정보 조회
        AccountInfoDTO toAccount = accountRepository.getAccount(transferInfo.getAccountNumber2());
        // 출금 및 입금 처리
        AccountService accountService = new AccountServiceImpl();
        accountService.transfer(fromAccount, toAccount, transferInfo.getTranAmt(), transferInfo);

        // 업데이트된 계좌 정보 반환
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        // 입금, 출금 값 보기
        out.print(gson.toJson(fromAccount));
        out.print(gson.toJson(toAccount));
        out.flush();
    }
    
    

}