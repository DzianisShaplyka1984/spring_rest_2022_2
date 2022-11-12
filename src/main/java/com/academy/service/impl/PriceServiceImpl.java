package com.academy.service.impl;

import com.academy.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  @Override
  public double getPrice(Integer id) {
    return Math.random();
  }
}
