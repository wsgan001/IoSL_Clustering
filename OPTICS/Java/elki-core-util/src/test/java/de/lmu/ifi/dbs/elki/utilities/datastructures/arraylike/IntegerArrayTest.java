package de.lmu.ifi.dbs.elki.utilities.datastructures.arraylike;
/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2016
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

/**
 * Unit test for this arraylist of primitive ints.
 *
 * @author Erich Schubert
 * @since 0.7.1
 */
public class IntegerArrayTest {
  @Test
  public void basicTest() {
    IntegerArray arr = new IntegerArray(11);
    assertEquals("Allocation does not match.", 11, arr.data.length);
    assertEquals("Initial size is not empty.", 0, arr.size());

    Random r = new Random(0L);
    for(int i = 0; i < 11; i++) {
      arr.add(r.nextInt());
    }
    assertEquals("Array is not full.", arr.data.length, arr.size());
    arr.add(r.nextInt());
    assertEquals("Allocation does not match after resize.", 17, arr.data.length);
    for(int i = 0; i < 81; i++) {
      arr.add(r.nextInt());
    }
    assertEquals("Array does not have expected size.", 11 + 1 + 81, arr.size());
    arr.sort();
    assertEquals("Allocation does not match after resize.", 139, arr.data.length);
    int prev = arr.get(0);
    for(int i = 1; i < arr.size(); i++) {
      int next = arr.get(i);
      assertTrue("Array is not sorted.", prev <= next);
      prev = next;
    }
  }
}
