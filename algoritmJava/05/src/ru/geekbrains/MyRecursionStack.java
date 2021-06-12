package ru.geekbrains;

import java.util.Stack;

public class MyRecursionStack {
    public static Clients recursionStack(Stack<Clients> clientsStack){
        if(!clientsStack.isEmpty()){
            clientsStack.pop().infoClients();
            return recursionStack(clientsStack);
        } else return null;


    }

}
