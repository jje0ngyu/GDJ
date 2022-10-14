<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	// 요청 파라미터
 	request.setCharacterEncoding("UTF-8");
 	String item = request.getParameter("item");
 	int amount = Integer.parseInt(request.getParameter("amount"));
 	//* 파라미터는 String타입이므로 int타입으로 캐스팅!
 	
 	// 제품+구매수량 → Map (장바구니에 담을 Map)
 	Map<String, Object> product = new HashMap<>();
 	//* Object에는 'item'과 'amount'가 함께 묶여야한다.
 	product.put("item", item);	//* Map에 저장하는 입력값 : put()
 	product.put("amount", amount);
 	
 	//* 장바구니는 session 저장
 	// session에 장바구니를 cart 속성으로 저장한 상황이다.
 	// 1. session에 cart 속성이 있는지 확인한다.
 	// 2. cart 속성이 없으면 새로 만들어서 저장한다.
 	
 	//* 장바구니에 담은 물건이 있다면, 기존 카트에 추가로 저장
 	List<Map<String, Object>> cart = (List<Map<String, Object>>)session.getAttribute("cart");
 	
 	//* 장바구니에 처음 담는다면, 새 카트에 저장
 	if(cart == null) {
 		cart = new ArrayList<>();
 		session.setAttribute("cart", cart);
 	}
 	
 	// session의 cart에 product 저장하기
 	cart.add(product);
 %>
 
<script>
	alert('<%=product.get("item")%>제품을 장바구니에 추가했습니다.');
	if(confirm('장바구니를 확인하려면 "확인", 계속 쇼핑하려면 "취소"를 누르세요.')){
		location.href='03_cart_list.jsp';
	} else {
		location.href='01_form.jsp';
	}
</script>