/*
 *     Copyright (C) 2015  higherfrequencytrading.com
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.openhft.chronicle.queue.impl.single;

import net.openhft.chronicle.queue.ChronicleQueueTestBase;
import net.openhft.chronicle.wire.WireKey;
import org.junit.Test;

import java.io.IOException;

public class SingleChronicleQueueFormatTest extends ChronicleQueueTestBase {

    @Test
    public void testHeaderCreation() throws IOException {
        SingleChronicleQueueFormat.from(SingleChronicleQueueBuilder.text(getTmpFile()));
    }

    @Test
    public void testSimpleAppend() throws IOException {
        SingleChronicleQueueFormat format =
            SingleChronicleQueueFormat.from(SingleChronicleQueueBuilder.text(getTmpFile()));

        for(int i=0; i<10; i++) {
            final int n = i;
            format.append(w -> w.write(TestKey.test).text("event " +  n));
        }
    }

    enum TestKey implements WireKey {
        test
    }
}
