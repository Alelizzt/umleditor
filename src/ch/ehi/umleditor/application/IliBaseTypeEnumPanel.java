package ch.ehi.umleditor.application;

/* This file is part of the UML/INTERLIS-Editor.
 * For more information, please see <http://www.umleditor.org/>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
import javax.swing.tree.*;
import ch.softenvironment.util.*;
import ch.softenvironment.view.*;
import ch.ehi.interlis.domainsandconstants.basetypes.*;
/**
 * INTERLIS BaseType representation of <b>Enumeration</b>.
 * 
 * @author: Peter Hirzel <i>soft</i>Environment 
 * @version $Revision: 1.1.1.1 $ $Date: 2003-12-23 10:39:02 $
 */
public class IliBaseTypeEnumPanel extends DataPanel {
	private static java.util.ResourceBundle resourceBundle = java.util.ResourceBundle.getBundle("ch/ehi/umleditor/application/resources/IliBaseTypeEnumPanel");  //$NON-NLS-1$
        private Enumeration root=new Enumeration();
        private EnumTreeModel model=null;
	private javax.swing.JRadioButton ivjRbtOrdered = null;
	private javax.swing.JRadioButton ivjRbtOrderedCircular = null;
	private javax.swing.JScrollPane ivjScpTree = null;
	private javax.swing.JRadioButton ivjRbtUndefined = null;
	private javax.swing.JTree ivjTreEnumeration = null;
	private javax.swing.JLabel ivjLblKind = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private javax.swing.JPopupMenu ivjJPopupMenu1 = null;
	private javax.swing.JMenuItem ivjMniNewDeep = null;
	private javax.swing.JMenuItem ivjMniNewFlat = null;
	private javax.swing.JMenuItem ivjMniRemove = null;
	private javax.swing.JSeparator ivjJSeparator1 = null;
	private javax.swing.JMenuItem ivjMniRename = null;
	private DescriptionPanel ivjPnlDescription = null;
	private javax.swing.JLabel ivjLblElementDescription = null;
	private javax.swing.JLabel ivjLblElements = null;
	private javax.swing.JPanel ivjJPanel1 = null;
	private javax.swing.JPanel ivjPnlKind = null;

class IvjEventHandler implements ch.ehi.umleditor.application.DescriptionPanelListener, java.awt.event.ActionListener, java.awt.event.MouseListener, javax.swing.event.TreeSelectionListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == IliBaseTypeEnumPanel.this.getMniNewFlat()) 
				connEtoC3(e);
			if (e.getSource() == IliBaseTypeEnumPanel.this.getMniNewDeep()) 
				connEtoC4(e);
			if (e.getSource() == IliBaseTypeEnumPanel.this.getMniRemove()) 
				connEtoC5(e);
			if (e.getSource() == IliBaseTypeEnumPanel.this.getMniRename()) 
				connEtoC6(e);
		};
		public void mouseClicked(java.awt.event.MouseEvent e) {};
		public void mouseEntered(java.awt.event.MouseEvent e) {};
		public void mouseExited(java.awt.event.MouseEvent e) {};
		public void mousePressed(java.awt.event.MouseEvent e) {
			if (e.getSource() == IliBaseTypeEnumPanel.this.getTreEnumeration()) 
				connEtoC8(e);
		};
		public void mouseReleased(java.awt.event.MouseEvent e) {
			if (e.getSource() == IliBaseTypeEnumPanel.this.getTreEnumeration()) 
				connEtoC1(e);
		};
		public void pnlEditorSimpleEditorPanel_txaEditorKey_keyReleased(java.util.EventObject newEvent) {
			if (newEvent.getSource() == IliBaseTypeEnumPanel.this.getPnlDescription()) 
				connEtoC7(newEvent);
		};
		public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
			if (e.getSource() == IliBaseTypeEnumPanel.this.getTreEnumeration()) 
				connEtoC2(e);
		};
	};
/**
 * IliBaseTypeTextPanel constructor comment.
 */
public IliBaseTypeEnumPanel() {
	super();
	initialize();
}
/**
 * Factory method to create a popup menu which allows to add attributes and methods.
 *
 * @return newly created popup menu
 * @see showSpecification()
 */
protected javax.swing.JPopupMenu adaptPopupMenu(javax.swing.JPopupMenu popupMenu) {
	EnumElement node = getSelectedNode();

	boolean isEnabled = (node != null) && (node != getTreEnumeration().getModel().getRoot());
	getMniNewDeep().setEnabled(node != null);
//	getMniNewFlat().setEnabled(isEnabled);
	getMniRemove().setEnabled(isEnabled);
	getMniRename().setEnabled(node != null);

	return popupMenu;
}
/**
 * connEtoC1:  (TreEnumeration.mouse.mouseReleased(java.awt.event.MouseEvent) --> IliBaseTypeEnumPanel.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getJPopupMenu1());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (TreEnumeration.treeSelection.valueChanged(javax.swing.event.TreeSelectionEvent) --> IliBaseTypeEnumPanel.selectionChanged(Ljavax.swing.event.TreeSelectionEvent;)V)
 * @param arg1 javax.swing.event.TreeSelectionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(javax.swing.event.TreeSelectionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.selectionChanged(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (MniNewFlat.action.actionPerformed(java.awt.event.ActionEvent) --> IliBaseTypeEnumPanel.mniNewFlat()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniNewFlat();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  (MniNewDeep.action.actionPerformed(java.awt.event.ActionEvent) --> IliBaseTypeEnumPanel.mniNewDeep()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniNewDeep();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (MniRemove.action.actionPerformed(java.awt.event.ActionEvent) --> IliBaseTypeEnumPanel.mniRemove()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniRemove();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (MniRename.action.actionPerformed(java.awt.event.ActionEvent) --> IliBaseTypeEnumPanel.mniRename()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniRename();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC7:  (PnlDescription.descriptionPanel.pnlEditorSimpleEditorPanel_txaEditorKey_keyReleased(java.util.EventObject) --> IliBaseTypeEnumPanel.saveDocumentation()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC7(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.saveDocumentation();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC8:  (TreEnumeration.mouse.mousePressed(java.awt.event.MouseEvent) --> IliBaseTypeEnumPanel.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC8(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getJPopupMenu1());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
private Enumeration copyTree(Enumeration src) {
    Enumeration ret=new Enumeration();
    ret.setKind(src.getKind());

    java.util.Iterator subi=src.iteratorEnumElement();
    while(subi.hasNext()){
      EnumElement subsrc=(EnumElement)subi.next();
      EnumElement subdest=new EnumElement();
      ret.addEnumElement(subdest);
      subdest.setDocumentation(subsrc.getDocumentation());
      subdest.setName(subsrc.getName());
      subdest.setNameList(subsrc.getNameList());
      if(subsrc.containsChild()){
        subdest.attachChild(copyTree(subsrc.getChild()));
      }
    }
    return ret;
}
protected void finalize()
{
  if (model!=null ) {
    // unregister Listener
    ch.ehi.uml1_4.changepropagation.MetaModel.getInstance().removeMetaModelListener(model);
  }
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel1() {
	if (ivjJPanel1 == null) {
		try {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsLblElementDescription = new java.awt.GridBagConstraints();
			constraintsLblElementDescription.gridx = 1; constraintsLblElementDescription.gridy = 1;
			constraintsLblElementDescription.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsLblElementDescription.ipadx = 140;
			constraintsLblElementDescription.ipady = 14;
			constraintsLblElementDescription.insets = new java.awt.Insets(7, 7, 2, 132);
			getJPanel1().add(getLblElementDescription(), constraintsLblElementDescription);

			java.awt.GridBagConstraints constraintsPnlDescription = new java.awt.GridBagConstraints();
			constraintsPnlDescription.gridx = 1; constraintsPnlDescription.gridy = 2;
			constraintsPnlDescription.fill = java.awt.GridBagConstraints.BOTH;
			constraintsPnlDescription.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsPnlDescription.weightx = 1.0;
			constraintsPnlDescription.weighty = 1.0;
			constraintsPnlDescription.ipadx = 243;
			constraintsPnlDescription.ipady = 69;
			constraintsPnlDescription.insets = new java.awt.Insets(2, 5, 3, 5);
			getJPanel1().add(getPnlDescription(), constraintsPnlDescription);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPanel1;
}
/**
 * Return the JPopupMenu1 property value.
 * @return javax.swing.JPopupMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPopupMenu getJPopupMenu1() {
	if (ivjJPopupMenu1 == null) {
		try {
			ivjJPopupMenu1 = new javax.swing.JPopupMenu();
			ivjJPopupMenu1.setName("JPopupMenu1");
			ivjJPopupMenu1.add(getMniNewFlat());
			ivjJPopupMenu1.add(getMniNewDeep());
			ivjJPopupMenu1.add(getJSeparator1());
			ivjJPopupMenu1.add(getMniRemove());
			ivjJPopupMenu1.add(getMniRename());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPopupMenu1;
}
/**
 * Return the JSeparator1 property value.
 * @return javax.swing.JSeparator
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JSeparator getJSeparator1() {
	if (ivjJSeparator1 == null) {
		try {
			ivjJSeparator1 = new javax.swing.JSeparator();
			ivjJSeparator1.setName("JSeparator1");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJSeparator1;
}
/**
 * Return Kind.
 */
private int getkind() {
	if (getRbtUndefined().isSelected()) {
		return EnumKind.UNDEFINED;
	} else if (getRbtOrdered().isSelected()) {
		return EnumKind.ORDERED;
	} else if (getRbtOrderedCircular().isSelected()) {
		return EnumKind.CIRCULAR;
	} else {
		throw new DeveloperException(this, "getKind()", "nothing choosed");//$NON-NLS-2$//$NON-NLS-1$
	}
}
/**
 * Return the LblElementDescription property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblElementDescription() {
	if (ivjLblElementDescription == null) {
		try {
			ivjLblElementDescription = new javax.swing.JLabel();
			ivjLblElementDescription.setName("LblElementDescription");
			ivjLblElementDescription.setText("Beschreibung:");
			// user code begin {1}
			ivjLblElementDescription.setText(resourceBundle.getString("LblElementDescription_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLblElementDescription;
}
/**
 * Return the LblElements property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblElements() {
	if (ivjLblElements == null) {
		try {
			ivjLblElements = new javax.swing.JLabel();
			ivjLblElements.setName("LblElements");
			ivjLblElements.setText("Elemente:");
			// user code begin {1}
			ivjLblElements.setText(resourceBundle.getString("LblElements_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLblElements;
}
/**
 * Return the LblKind property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblKind() {
	if (ivjLblKind == null) {
		try {
			ivjLblKind = new javax.swing.JLabel();
			ivjLblKind.setName("LblKind");
			ivjLblKind.setAlignmentY(java.awt.Component.TOP_ALIGNMENT);
			ivjLblKind.setText("Art:");
			ivjLblKind.setBounds(9, 7, 140, 14);
			// user code begin {1}
			ivjLblKind.setText(resourceBundle.getString("LblKind_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLblKind;
}
/**
 * Return the MniNewDeep property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniNewDeep() {
	if (ivjMniNewDeep == null) {
		try {
			ivjMniNewDeep = new javax.swing.JMenuItem();
			ivjMniNewDeep.setName("MniNewDeep");
			ivjMniNewDeep.setText("Neu (Unteraufz�hlung)");
			// user code begin {1}
			ivjMniNewDeep.setText(resourceBundle.getString("MniNewDeep_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniNewDeep;
}
/**
 * Return the MniNewFlat property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniNewFlat() {
	if (ivjMniNewFlat == null) {
		try {
			ivjMniNewFlat = new javax.swing.JMenuItem();
			ivjMniNewFlat.setName("MniNewFlat");
			ivjMniNewFlat.setText("Neu");
			// user code begin {1}
			ivjMniNewFlat.setText(MENU_FILE_NEW);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniNewFlat;
}
/**
 * Return the MniRemove property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniRemove() {
	if (ivjMniRemove == null) {
		try {
			ivjMniRemove = new javax.swing.JMenuItem();
			ivjMniRemove.setName("MniRemove");
			ivjMniRemove.setText("L�schen");
			// user code begin {1}
			ivjMniRemove.setText(MENU_EDIT_REMOVE);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniRemove;
}
/**
 * Return the MniRename property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniRename() {
	if (ivjMniRename == null) {
		try {
			ivjMniRename = new javax.swing.JMenuItem();
			ivjMniRename.setName("MniRename");
			ivjMniRename.setText("Umbenennen");
			// user code begin {1}
			ivjMniRename.setText(MENU_EDIT_RENAME);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniRename;
}
/**
 * Return the changed object displayed.
 */
public java.lang.Object getObject() {
	Enumeration type = copyTree(root);
	type.setKind(getkind());
	return type;
}
/**
 * Return the PnlDescription property value.
 * @return ch.ehi.umleditor.application.DescriptionPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private DescriptionPanel getPnlDescription() {
	if (ivjPnlDescription == null) {
		try {
			ivjPnlDescription = new ch.ehi.umleditor.application.DescriptionPanel();
			ivjPnlDescription.setName("PnlDescription");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlDescription;
}
/**
 * Return the PnlKind property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPnlKind() {
	if (ivjPnlKind == null) {
		try {
			ivjPnlKind = new javax.swing.JPanel();
			ivjPnlKind.setName("PnlKind");
			ivjPnlKind.setLayout(null);
			getPnlKind().add(getLblKind(), getLblKind().getName());
			getPnlKind().add(getRbtUndefined(), getRbtUndefined().getName());
			getPnlKind().add(getRbtOrdered(), getRbtOrdered().getName());
			getPnlKind().add(getRbtOrderedCircular(), getRbtOrderedCircular().getName());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlKind;
}
/**
 * Return the RbtOrdered property value.
 * @return javax.swing.JRadioButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JRadioButton getRbtOrdered() {
	if (ivjRbtOrdered == null) {
		try {
			ivjRbtOrdered = new javax.swing.JRadioButton();
			ivjRbtOrdered.setName("RbtOrdered");
			ivjRbtOrdered.setToolTipText("Geordnet");
			ivjRbtOrdered.setAlignmentY(java.awt.Component.TOP_ALIGNMENT);
			ivjRbtOrdered.setText("ORDERED");
			ivjRbtOrdered.setBounds(159, 29, 140, 22);
			// user code begin {1}
			ivjRbtOrdered.setToolTipText(resourceBundle.getString("RbtOrdered_toolTipText"));
			ivjRbtOrdered.setText(resourceBundle.getString("RbtOrdered_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRbtOrdered;
}
/**
 * Return the RbtOrderedCircular property value.
 * @return javax.swing.JRadioButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JRadioButton getRbtOrderedCircular() {
	if (ivjRbtOrderedCircular == null) {
		try {
			ivjRbtOrderedCircular = new javax.swing.JRadioButton();
			ivjRbtOrderedCircular.setName("RbtOrderedCircular");
			ivjRbtOrderedCircular.setToolTipText("Geordnet & Zirkul�r");
			ivjRbtOrderedCircular.setAlignmentY(java.awt.Component.TOP_ALIGNMENT);
			ivjRbtOrderedCircular.setText("CIRCULAR");
			ivjRbtOrderedCircular.setBounds(159, 53, 140, 22);
			// user code begin {1}
			ivjRbtOrderedCircular.setToolTipText(resourceBundle.getString("RbtOrderedCircular_toolTipText"));
			ivjRbtOrderedCircular.setText(resourceBundle.getString("RbtOrderedCircular_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRbtOrderedCircular;
}
/**
 * Return the RbtOrdered property value.
 * @return javax.swing.JRadioButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JRadioButton getRbtUndefined() {
	if (ivjRbtUndefined == null) {
		try {
			ivjRbtUndefined = new javax.swing.JRadioButton();
			ivjRbtUndefined.setName("RbtUndefined");
			ivjRbtUndefined.setAlignmentY(java.awt.Component.TOP_ALIGNMENT);
			ivjRbtUndefined.setText("Undefiniert");
			ivjRbtUndefined.setBounds(159, 3, 140, 22);
			// user code begin {1}
			ivjRbtUndefined.setText(resourceBundle.getString("RbtUndefined_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRbtUndefined;
}
/**
 * Return the ScpTree property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getScpTree() {
	if (ivjScpTree == null) {
		try {
			ivjScpTree = new javax.swing.JScrollPane();
			ivjScpTree.setName("ScpTree");
			ivjScpTree.setAutoscrolls(true);
			getScpTree().setViewportView(getTreEnumeration());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScpTree;
}
/**
 * Returns the TreeNode instance that is selected in the tree.
 * If nothing is selected, null is returned.
 */
private EnumElement getSelectedNode() {
	TreePath selPath = getTreEnumeration().getSelectionPath();

	if (selPath != null) {
		return (EnumElement)selPath.getLastPathComponent();
	}
	return null;
}
/**
 * Returns the TreeModel of JTree.
 */
private TreeModel getTreeModel() {
	return getTreEnumeration().getModel();
}
/**
 * Return the TreEnumeration property value.
 * @return javax.swing.JTree
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTree getTreEnumeration() {
	if (ivjTreEnumeration == null) {
		try {
			ivjTreEnumeration = new javax.swing.JTree();
			ivjTreEnumeration.setName("TreEnumeration");
			ivjTreEnumeration.setAutoscrolls(true);
			ivjTreEnumeration.setBounds(0, 0, 78, 72);
			ivjTreEnumeration.setEnabled(true);
			ivjTreEnumeration.setEditable(true);
			ivjTreEnumeration.setInvokesStopCellEditing(true);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTreEnumeration;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
protected void handleException(java.lang.Throwable exception) {
	LauncherView.getInstance().handleException(exception);
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getTreEnumeration().addMouseListener(ivjEventHandler);
	getTreEnumeration().addTreeSelectionListener(ivjEventHandler);
	getMniNewFlat().addActionListener(ivjEventHandler);
	getMniNewDeep().addActionListener(ivjEventHandler);
	getMniRemove().addActionListener(ivjEventHandler);
	getMniRename().addActionListener(ivjEventHandler);
	getPnlDescription().addDescriptionPanelListener(ivjEventHandler);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("IliBaseTypeTextPanel");
		setToolTipText("");
		setLayout(new java.awt.GridBagLayout());
		setSize(467, 222);

		java.awt.GridBagConstraints constraintsScpTree = new java.awt.GridBagConstraints();
		constraintsScpTree.gridx = 1; constraintsScpTree.gridy = 3;
		constraintsScpTree.fill = java.awt.GridBagConstraints.BOTH;
		constraintsScpTree.anchor = java.awt.GridBagConstraints.NORTHWEST;
		constraintsScpTree.weightx = 1.0;
		constraintsScpTree.weighty = 1.0;
		constraintsScpTree.ipadx = 142;
		constraintsScpTree.ipady = 78;
		constraintsScpTree.insets = new java.awt.Insets(2, 10, 7, 4);
		add(getScpTree(), constraintsScpTree);

		java.awt.GridBagConstraints constraintsLblElements = new java.awt.GridBagConstraints();
		constraintsLblElements.gridx = 1; constraintsLblElements.gridy = 2;
		constraintsLblElements.anchor = java.awt.GridBagConstraints.NORTHWEST;
		constraintsLblElements.ipadx = 162;
		constraintsLblElements.ipady = 14;
		constraintsLblElements.insets = new java.awt.Insets(5, 12, 2, 4);
		add(getLblElements(), constraintsLblElements);

		java.awt.GridBagConstraints constraintsPnlKind = new java.awt.GridBagConstraints();
		constraintsPnlKind.gridx = 1; constraintsPnlKind.gridy = 1;
		constraintsPnlKind.gridwidth = 2;
		constraintsPnlKind.anchor = java.awt.GridBagConstraints.NORTHWEST;
		constraintsPnlKind.weightx = 1.0;
		constraintsPnlKind.weighty = 1.0;
		constraintsPnlKind.ipadx = 392;
		constraintsPnlKind.ipady = 86;
		constraintsPnlKind.insets = new java.awt.Insets(6, 6, 0, 69);
		add(getPnlKind(), constraintsPnlKind);

		java.awt.GridBagConstraints constraintsJPanel1 = new java.awt.GridBagConstraints();
		constraintsJPanel1.gridx = 2; constraintsJPanel1.gridy = 2;
constraintsJPanel1.gridheight = 2;
		constraintsJPanel1.fill = java.awt.GridBagConstraints.BOTH;
		constraintsJPanel1.anchor = java.awt.GridBagConstraints.NORTHWEST;
		constraintsJPanel1.weightx = 1.0;
		constraintsJPanel1.weighty = 1.0;
		constraintsJPanel1.insets = new java.awt.Insets(1, 4, 6, 6);
		add(getJPanel1(), constraintsJPanel1);
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	setToolTipText(resourceBundle.getString("IliBaseTypeTextPanel_toolTipText"));
	javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
	group.add(getRbtUndefined());
	group.add(getRbtOrdered());
	group.add(getRbtOrderedCircular());
	getRbtUndefined().setSelected(true);
	getPnlDescription().setEnabled(false);
Tracer.getInstance().developerWarning(this, "initialize()", "initialization causes a corrupt TabPanel in AttributeDefDialog->Visual Builder");
	initializeTree();
	// user code end
}
/**
 * Initialize the Tree.
 */
private void initializeTree() {
/*
  java.awt.event.MouseListener ml = new java.awt.event.MouseAdapter() {
     public void mousePressed(java.awt.event.MouseEvent e) {
         int selRow = getTreEnumeration().getRowForLocation(e.getX(), e.getY());
         //TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
         if(selRow != -1) {
             if(e.getClickCount() == 1) {
                 getTreEnumeration().clearSelection();
             }
         }
     }
 };
 getTreEnumeration().addMouseListener(ml);
 */
    EnumTreeCellRenderer renderer = new EnumTreeCellRenderer();
    getTreEnumeration().setCellRenderer(renderer);

	// Cell editing
    getTreEnumeration().setCellEditor(new EnumTreeCellEditor(getTreEnumeration(), renderer));

    //   getTreNavigation().getCellEditor().addCellEditorListener(this);
	getTreEnumeration().setEditable(true);
	getTreEnumeration().setInvokesStopCellEditing(true);

    // make tree ask for the height of each row
    getTreEnumeration().setRowHeight(-1);

    getTreEnumeration().setRootVisible(false);
    getTreEnumeration().setShowsRootHandles(true);

    // set Single Row selection model
    DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
    selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    getTreEnumeration().setSelectionModel(selectionModel);

    // Enable tool tips for the tree
    javax.swing.ToolTipManager.sharedInstance().registerComponent(getTreEnumeration());

    // show lines from Parent to leaf
    getTreEnumeration().putClientProperty("JTree.lineStyle", "Angled");//$NON-NLS-2$//$NON-NLS-1$

    model=new EnumTreeModel();
    model.setRoot(root);
    ch.ehi.uml1_4.changepropagation.MetaModel.getInstance().addMetaModelListener(model);
    getTreEnumeration().setModel(model);

    // expand first element
    getTreEnumeration().expandRow(1);
}
/**
 * Create new Subtree at selected node.
 */
private void mniNewDeep() {
	try {
		EnumElement parentNode = getSelectedNode();
		EnumElement newElement = ElementFactory.createEnumElement();
                if(!parentNode.containsChild()){
                  parentNode.attachChild(new Enumeration());
                }
                parentNode.getChild().addEnumElement(newElement);

	} catch(Throwable e) {
		handleException(e);
	}
}
/**
 * Add leaf to selected node.
 */
private void mniNewFlat() {
	try {
		EnumElement selectedNode = getSelectedNode();

		EnumElement newElement = ElementFactory.createEnumElement();

		if (selectedNode==null){
                        root.addEnumElement(newElement);
                }else if(selectedNode.getEnumeration()==root) {
			// use Root
                        int idx=root.findEnumElement(selectedNode);
                        root.addEnumElement(idx,newElement);
		} else {
                        int idx=selectedNode.getEnumeration().findEnumElement(selectedNode);
                        selectedNode.getEnumeration().addEnumElement(idx,newElement);
		}
	} catch(Throwable e) {
		handleException(e);
	}
}
/**
 * Comment
 */
private void mniRemove() {
	EnumElement selectedNode = getSelectedNode();
	if (selectedNode==null || selectedNode.getEnumeration()==root) {
		// use Root
                root.removeEnumElement(selectedNode);
	} else {
                selectedNode.getEnumeration().removeEnumElement(selectedNode);
	}
}
/**
 * Start renaming by setting Cursor on TreeNode.
 */
private void mniRename() {
	getTreEnumeration().startEditingAtPath(getTreEnumeration().getSelectionPath());
}
/**
 * Save the documentation on currently selected EnumElement.
 */
private void saveDocumentation() {
	getPnlDescription().getObject();
}
/**
 * Adapt anything when Tree-Selection changes.
 */
private void selectionChanged(javax.swing.event.TreeSelectionEvent treeSelectionEvent) {
	EnumElement node = getSelectedNode();
	if (node == null) {
		getPnlDescription().setEnabled(false);
		getPnlDescription().setObject(null);
	} else {
		// EnumElement
		getPnlDescription().setEnabled(true);
		getPnlDescription().setObject(node);
	}
}
/**
 * Set the Object to be displayed by panel.
 */
public void setObject(java.lang.Object object) {
        if(object==null){
          root=new Enumeration();
        }else{
          root=copyTree((Enumeration)object);
        }
	Enumeration type = root;
	switch (type.getKind()) {
		case EnumKind.UNDEFINED: {
			getRbtUndefined().setSelected(true);
			break;
		}
		case EnumKind.ORDERED: {
			getRbtOrdered().setSelected(true);
			break;
		}
		case EnumKind.CIRCULAR: {
			getRbtOrderedCircular().setSelected(true);
			break;
		}
		default: {
			throw new ch.softenvironment.util.DeveloperException(this, "setKind()", "Unknown Kind <" + type.getKind() + ">");//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
		}
	}

	model.setRoot(root);
}
}