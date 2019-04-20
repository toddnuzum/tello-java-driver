/*
 * MIT License
 *
 * Copyright © 2019 Bas de Groot
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.bdg91.tello.util;

public class Assert {

    public static void validDistance(final int distanceInCm) {
        if (distanceInCm < 20 | distanceInCm > 500) {
            throw new IllegalArgumentException("The minimum allowed validDistance is 20, the maximum allowed validDistance is 500.");
        }
    }

    public static void validDegrees(final int degrees) {
        if (degrees < 1 | degrees > 3600) {
            throw new IllegalArgumentException("The minimum amount of validDegrees is 1, the maximum amount of validDegrees is 3600.");
        }
    }
}
