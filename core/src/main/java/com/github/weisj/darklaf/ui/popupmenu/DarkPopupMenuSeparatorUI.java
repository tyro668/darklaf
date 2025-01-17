/*
 * MIT License
 *
 * Copyright (c) 2019-2021 Jannis Weis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.github.weisj.darklaf.ui.popupmenu;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;

import com.github.weisj.darklaf.ui.separator.DarkSeparatorUI;

/** @author Jannis Weis */
public class DarkPopupMenuSeparatorUI extends DarkSeparatorUI {

    public static ComponentUI createUI(final JComponent c) {
        return new DarkPopupMenuSeparatorUI();
    }

    @Override
    protected void installDefaults(final JSeparator s) {
        super.installDefaults(s);
        size = UIManager.getDimension("PopupMenuDivider.size");
    }

    @Override
    public void paint(final Graphics g, final JComponent c) {
        Dimension s = c.getSize();
        g.setColor(UIManager.getDefaults().getColor("PopupMenu.borderColor"));
        g.fillRect(0, size.height / 2, s.width, 1);
    }

    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return new Dimension(0, size.height);
    }
}
