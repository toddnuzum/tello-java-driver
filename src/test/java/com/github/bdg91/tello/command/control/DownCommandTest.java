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

package com.github.bdg91.tello.command.control;

import com.github.bdg91.tello.client.TelloClient;
import com.github.bdg91.tello.command.Command;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DownCommandTest {

    @Mock
    private TelloClient telloClient;

    private static final String COMMAND = "down";
    private static final String SPACE = " ";
    private static final int DISTANCE = 50;

    private Command command;

    @Before
    public void setUp() {
        command = new DownCommand(telloClient, DISTANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_distance_to_low() {
        command = new DownCommand(telloClient, 19);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_distance_to_high() {
        command = new DownCommand(telloClient, 501);
    }

    @Test(expected = IOException.class)
    public void testExecute_io_exception() throws Exception {
        when(telloClient.sendCommand(COMMAND + SPACE + DISTANCE)).thenThrow(IOException.class);

        command.execute();
    }

    @Test
    public void testExecute() throws IOException {
        command.execute();

        verify(telloClient).sendCommand(COMMAND + SPACE + DISTANCE);
    }
}
