package com.example.myapplication;

import java.util.Random;

public class GeneratorInterfaceImplementation extends GeneratorInterface.Stub{
    @Override
    public int randomNumberGenerator(int start,int stop){
        Random random = new Random();
        return random.nextInt(stop);
    }
}