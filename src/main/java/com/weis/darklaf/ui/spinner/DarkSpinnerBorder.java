package com.weis.darklaf.ui.spinner;

import com.weis.darklaf.util.DarkUIUtil;
import com.weis.darklaf.util.GraphicsContext;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.UIResource;
import java.awt.*;

/**
 * @author Konstantin Bulenkov
 * @author Jannis Weis
 */
public class DarkSpinnerBorder implements Border, UIResource {

    protected Color focusBorderColor;
    protected Color borderColor;
    protected Color inactiveBorderColor;
    protected int arc;
    protected int borderSize;

    public DarkSpinnerBorder() {
        focusBorderColor = UIManager.getColor("Spinner.focusBorderColor");
        borderColor = UIManager.getColor("Spinner.activeBorderColor");
        inactiveBorderColor = UIManager.getColor("Spinner.inactiveBorderColor");
        arc = UIManager.getInt("Spinner.arc");
        borderSize = UIManager.getInt("Spinner.borderThickness");
    }

    @Override
    public void paintBorder(@NotNull final Component c, final Graphics g2,
                            final int x, final int y, final int width, final int height) {
        boolean tableCellEditor = DarkSpinnerUI.isTableCellEditor(c);
        boolean treeCellEditor = !tableCellEditor && DarkSpinnerUI.isTreeCellEditor(c);

        Graphics2D g = (Graphics2D) g2;
        GraphicsContext config = new GraphicsContext(g);
        g.translate(x, y);

        int size = tableCellEditor ? 0 : borderSize;

        if (c instanceof JSpinner) {
            JSpinner spinner = (JSpinner) c;
            JComponent editor = spinner.getEditor();
            if (editor != null) {
                int off = spinner.getComponentOrientation().isLeftToRight()
                          ? editor.getBounds().x + editor.getWidth()
                          : editor.getBounds().x - 1 - borderSize;
                g.setColor(getBorderColor(spinner));
                if (!treeCellEditor) {
                    g.fillRect(off, size, 1, height - 2 * size);
                } else {
                    g.fillRect(off, 0, 1, height);
                }
            }
        }

        if (!tableCellEditor && !treeCellEditor && DarkUIUtil.hasFocus(c)) {
            DarkUIUtil.paintFocusBorder(g, width, height, arc, borderSize);
        }

        g.setColor(getBorderColor(c));
        if (!tableCellEditor && !treeCellEditor) {
            if (DarkUIUtil.hasFocus(c)) {
                g.setColor(focusBorderColor);
            }
            DarkUIUtil.paintLineBorder(g, size, size, width - 2 * size, height - 2 * size, arc, true);
        } else if (tableCellEditor && (c.getParent() instanceof JTable)) {
            var table = (JTable) c.getParent();
            if (!table.getShowHorizontalLines()) {
                g.fillRect(0, 0, width, 1);
                g.fillRect(0, height - 1, width, 1);
            }
            if (!table.getShowVerticalLines()) {
                g.fillRect(0, 0, 1, height);
                g.fillRect(width - 1, 0, 1, height);
            }
        } else {
            DarkUIUtil.drawRect(g, 0, 0, width, height, 1);
        }

        g.translate(-x, -y);
        config.restore();
    }

    protected Color getBorderColor(@NotNull final Component c) {
        return c.isEnabled() ? borderColor : inactiveBorderColor;
    }

    @Override
    public Insets getBorderInsets(final Component c) {
        if (DarkSpinnerUI.isTableCellEditor(c) || DarkSpinnerUI.isTreeCellEditor(c)) {
            return new InsetsUIResource(2, 5, 2, 5);
        }
        return new InsetsUIResource(7, 7, 7, 7);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
