package com.backend.service;

import java.util.List;

public interface CategoryService {
    boolean batchDelete(List<Integer> ids);
}
