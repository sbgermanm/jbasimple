/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample.repository;

import com.sebas.jbasample.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Sebasy
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
    
    
}
