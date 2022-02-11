package com.in28minutes.dataApi;

import java.util.List;

// create TodoServiceStub
//Test TodoBusinessImp using the TodoServiceStub
public interface TodoService {
     List<String> retrieveTodos(String user);
}
