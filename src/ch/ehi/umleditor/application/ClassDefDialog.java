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
import java.util.EventObject;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import ch.ehi.basics.types.NlsString;
import ch.ehi.interlis.attributes.*;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;
import ch.ehi.interlis.modeltopicclass.*;
import ch.ehi.uml1_4.foundation.extensionmechanisms.TaggedValue;
import ch.softenvironment.view.*;
import ch.softenvironment.util.*;
/**
 * User Interface for a ClassDef.
 *
 * @author Peter Hirzel <i>soft</i>Environment
 * @version $Revision: 1.5 $ $Date: 2007-01-14 08:17:16 $
 */
public class ClassDefDialog extends BaseDialog implements ListMenuChoice {
	// keep ModelElement
	private static java.util.ResourceBundle resClassDefDialog = java.util.ResourceBundle.getBundle("ch/ehi/umleditor/application/resources/ClassDefDialog");
	ch.ehi.interlis.modeltopicclass.ClassDef classDef = null;
	private javax.swing.JMenuItem mniMoveDownAttribute = null;
        // generated
	private javax.swing.JPanel ivjBaseDialogContentPane = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	EditorTableMetaAttribute objTableMetaAttribute = new EditorTableMetaAttribute();
	ForcedListSelectionModel objSelectionMetaAttribute = new ForcedListSelectionModel();
	private javax.swing.JButton ivjBtnCancel = null;
	private javax.swing.JButton ivjBtnOk = null;
	private javax.swing.JButton ivjBtnAddMetaAttribute = null;
	private javax.swing.JButton ivjBtnDeleteMetaAttribute = null;
	private javax.swing.JButton ivjBtnSaveMetaAttribute = null;
	private javax.swing.JTabbedPane ivjTbpGeneral = null;
	private javax.swing.JLabel ivjLblName = null;
	private javax.swing.JTextField ivjTxtName = null;
	private javax.swing.JButton ivjBtnApply = null;
	private javax.swing.JCheckBox ivjChxAbstract = null;
	private javax.swing.JCheckBox ivjChxFinal = null;
	private InterlisSyntaxPanel ivjPnlConstraints = null;
	private DescriptionPanel ivjPnlDescription = null;
	private InterlisSyntaxPanel ivjPnlParameters = null;
	private javax.swing.JScrollPane ivjScpAttributes = null;
	private javax.swing.JScrollPane ivjScpMetaAttributes = null;
	private TableColumn ivjTbcAttributeName = null;
	private TableColumn ivjTbcAttributeType = null;
	private TableColumn ivjTbcMetaAttributeName = null;
	private TableColumn ivjTbcMetaAttributeValue = null;
	private javax.swing.JTable ivjTblAttributes = null;
	private javax.swing.JTable ivjTblMetaAttributes = null;
	private javax.swing.DefaultListSelectionModel ivjLocalColumnModelDefaultListSelectionModel = null;
	private javax.swing.JPanel ivjPnlAttributes = null;
	private javax.swing.JPanel ivjPnlDetail = null;
	private javax.swing.JPanel ivjPnlMetaAttributes = null;
	private javax.swing.JMenuItem ivjMniNewAttribute = null;
	private javax.swing.JMenuItem ivjMniRemoveAttribute = null;
	private javax.swing.JSeparator ivjJSeparator1 = null;
	private javax.swing.JMenuItem ivjMniOpenAttributeSpecication = null;
	private javax.swing.JPopupMenu ivjMnuAttributes = null;
	private ExtendedPanel ivjPnlExtended = null;
	private javax.swing.JLabel ivjLblKind = null;
	private javax.swing.JRadioButton ivjRbtClass = null;
	private javax.swing.JRadioButton ivjRbtStructure = null;
	private javax.swing.JPanel ivjPnlClassKind = null;
	private TaggedValue ivjTaggedValue = null;

class IvjEventHandler implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.MouseListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == ClassDefDialog.this.getBtnOk())
				connEtoC1(e);
			if (e.getSource() == ClassDefDialog.this.getBtnCancel())
				connEtoC2(e);
			if (e.getSource() == ClassDefDialog.this.getBtnApply())
				connEtoC3(e);
			if (e.getSource() == ClassDefDialog.this.getMniNewAttribute())
				connEtoC5(e);
			if (e.getSource() == ClassDefDialog.this.getMniRemoveAttribute())
				connEtoC6(e);
			if (e.getSource() == ClassDefDialog.this.getBtnDeleteMetaAttribuite())
				connEtoC14(e);
			if (e.getSource() == ClassDefDialog.this.getBtnSaveMetaAttribuite())
				connEtoC15(e);
			if (e.getSource() == ClassDefDialog.this.getMniRemoveAttribute())
				connEtoC6(e);
			if (e.getSource() == ClassDefDialog.this.getMniOpenAttributeSpecication())
				connEtoC9(e);
		};
		public void focusGained(java.awt.event.FocusEvent e) {
			if (e.getSource() == ClassDefDialog.this.getTxtName())
				connEtoM1(e);
		};
		public void focusLost(java.awt.event.FocusEvent e) {};
		public void mouseClicked(java.awt.event.MouseEvent e) {};
		public void mouseEntered(java.awt.event.MouseEvent e) {};
		public void mouseExited(java.awt.event.MouseEvent e) {};
		public void mousePressed(java.awt.event.MouseEvent e) {
			if (e.getSource() == ClassDefDialog.this.getScpAttributes())
				connEtoC4(e);
			if (e.getSource() == ClassDefDialog.this.getTblAttributes())
				connEtoC10(e);
		};
		public void mouseReleased(java.awt.event.MouseEvent e) {
			if (e.getSource() == ClassDefDialog.this.getTblAttributes())
				connEtoC7(e);
			if (e.getSource() == ClassDefDialog.this.getScpAttributes())
				connEtoC8(e);
		};
	};
	
public class ForcedListSelectionModel extends DefaultListSelectionModel {

	private static final long serialVersionUID = 7845540618701507798L;

	public ForcedListSelectionModel() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	@Override
	public void clearSelection() {
	}

	@Override
	public void removeSelectionInterval(int index0, int index1) {
	}
}
/**
 * Constructor
 */
public ClassDefDialog(java.awt.Frame owner, ch.ehi.uml1_4.foundation.core.Element element) {
	super(owner, true);
	initialize();
	addEscapeKey();
	setRelativeLocation(owner);
	setElement(element);
	show();
}
/**
 * Constructor
 * @param owner Symbol
 * @param modal Symbol
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ClassDefDialog(java.awt.Frame owner, boolean modal) {
	super(owner, modal);
	initialize();
}
/**
 * Handle escape key to close the dialog
 */
 private void addEscapeKey() {
	 
	 KeyStroke escape = KeyStroke.getKeyStroke (KeyEvent.VK_ESCAPE, 0, false);
	 Action escapeAction = new AbstractAction() {
		
		private static final long serialVersionUID = -2972481431614869047L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			dispose();
		}
	 };
	 getRootPane ().getInputMap (JComponent.WHEN_IN_FOCUSED_WINDOW).put (escape, "ESCAPE");
	 getRootPane ().getActionMap ().put ("ESCAPE", escapeAction);
 }
/**
 * @see ch.softenvironment.view.ListMenuChoice#adaptUserAction(EventObject, Object)
 */
public void adaptUserAction(EventObject event, Object control) {
    try {
    	boolean isSelected = getTblAttributes().getSelectedRow() >= 0;
    	getMniOpenAttributeSpecication().setEnabled(isSelected);
    	getMniRemoveAttribute().setEnabled(isSelected);
    	mniMoveDownAttribute.setEnabled(isSelected);
    } catch(Throwable e) {
        handleException(e);
    }
}
/**
 * connEtoC1:  (BtnOk.action.actionPerformed(java.awt.event.ActionEvent) --> ClassDefDialog.okPressed()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.okPressed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC10:  (TblAttributes.mouse.mouseReleased(java.awt.event.MouseEvent) --> ClassDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC10(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuAttributes());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (BtnCancel.action.actionPerformed(java.awt.event.ActionEvent) --> ClassDefDialog.cancelPressed()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.cancelPressed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (BtnApply.action.actionPerformed(java.awt.event.ActionEvent) --> ClassDefDialog.applyPressed()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.applyPressed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  (ScpAttributes.mouse.mouseReleased(java.awt.event.MouseEvent) --> ClassDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuAttributes());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (MniNewAttribute.action.actionPerformed(java.awt.event.ActionEvent) --> ClassDefDialog.mniNewAttribute()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniNewAttribute();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (MniRemoveAttribute.action.actionPerformed(java.awt.event.ActionEvent) --> ClassDefDialog.mniRemoveAttribute()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniRemoveAttribute();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
private void connEtoC14(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniRemoveMetaAttribute();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
private void connEtoC15(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniSaveMetaAttribute();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC7:  (TblAttributes.mouse.mouseReleased(java.awt.event.MouseEvent) --> ClassDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC7(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuAttributes());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC8:  (ScpAttributes.mouse.mouseReleased(java.awt.event.MouseEvent) --> ClassDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC8(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuAttributes());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC9:  (MniOpenAttributeSpecication.action.actionPerformed(java.awt.event.ActionEvent) --> ClassDefDialog.mniShowAttributeSpecification()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC9(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniShowAttributeSpecification();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoM1:  (TxtName.focus.focusGained(java.awt.event.FocusEvent) --> TxtName.selectAll()V)
 * @param arg1 java.awt.event.FocusEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1(java.awt.event.FocusEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		getTxtName().selectAll();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the BaseDialogContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getBaseDialogContentPane() {
	if (ivjBaseDialogContentPane == null) {
		try {
			ivjBaseDialogContentPane = new javax.swing.JPanel();
			ivjBaseDialogContentPane.setName("BaseDialogContentPane");
			ivjBaseDialogContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsLblName = new java.awt.GridBagConstraints();
			constraintsLblName.gridx = 1; constraintsLblName.gridy = 1;
			constraintsLblName.ipadx = 104;
			constraintsLblName.insets = new java.awt.Insets(22, 11, 10, 6);
			getBaseDialogContentPane().add(getLblName(), constraintsLblName);

			java.awt.GridBagConstraints constraintsTxtName = new java.awt.GridBagConstraints();
			constraintsTxtName.gridx = 2; constraintsTxtName.gridy = 1;
			constraintsTxtName.gridwidth = 2;
			constraintsTxtName.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTxtName.weightx = 1.0;
			constraintsTxtName.ipadx = 315;
			constraintsTxtName.insets = new java.awt.Insets(19, 6, 7, 15);
			getBaseDialogContentPane().add(getTxtName(), constraintsTxtName);

			java.awt.GridBagConstraints constraintsTbpGeneral = new java.awt.GridBagConstraints();
			constraintsTbpGeneral.gridx = 1; constraintsTbpGeneral.gridy = 2;
			constraintsTbpGeneral.gridwidth = 3;
			constraintsTbpGeneral.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTbpGeneral.weightx = 1.0;
			constraintsTbpGeneral.weighty = 1.0;
			constraintsTbpGeneral.insets = new java.awt.Insets(8, 10, 5, 10);
			getBaseDialogContentPane().add(getTbpGeneral(), constraintsTbpGeneral);

			java.awt.GridBagConstraints constraintsBtnOk = new java.awt.GridBagConstraints();
			constraintsBtnOk.gridx = 1; constraintsBtnOk.gridy = 3;
			constraintsBtnOk.ipadx = 64;
			constraintsBtnOk.insets = new java.awt.Insets(6, 32, 12, 10);
			getBaseDialogContentPane().add(getBtnOk(), constraintsBtnOk);

			java.awt.GridBagConstraints constraintsBtnCancel = new java.awt.GridBagConstraints();
			constraintsBtnCancel.gridx = 2; constraintsBtnCancel.gridy = 3;
			constraintsBtnCancel.ipadx = 18;
			constraintsBtnCancel.insets = new java.awt.Insets(6, 33, 12, 15);
			getBaseDialogContentPane().add(getBtnCancel(), constraintsBtnCancel);

			java.awt.GridBagConstraints constraintsBtnApply = new java.awt.GridBagConstraints();
			constraintsBtnApply.gridx = 3; constraintsBtnApply.gridy = 3;
			constraintsBtnApply.ipadx = 16;
			constraintsBtnApply.insets = new java.awt.Insets(6, 16, 12, 38);
			getBaseDialogContentPane().add(getBtnApply(), constraintsBtnApply);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBaseDialogContentPane;
}
/**
 * Return the BtnApply property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getBtnApply() {
	if (ivjBtnApply == null) {
		try {
			ivjBtnApply = new javax.swing.JButton();
			ivjBtnApply.setName("BtnApply");
			ivjBtnApply.setText("Uebernehmen");
			// user code begin {1}
			ivjBtnApply.setText(getApplyString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBtnApply;
}
/**
 * Return the JButton2 property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getBtnCancel() {
	if (ivjBtnCancel == null) {
		try {
			ivjBtnCancel = new javax.swing.JButton();
			ivjBtnCancel.setName("BtnCancel");
			ivjBtnCancel.setText("Abbrechen");
			// user code begin {1}
			ivjBtnCancel.setText(getCancelString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBtnCancel;
}
/**
 * Return the JButton1 property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getBtnOk() {
	if (ivjBtnOk == null) {
		try {
			ivjBtnOk = new javax.swing.JButton();
			ivjBtnOk.setName("BtnOk");
			ivjBtnOk.setText("Ok");
			// user code begin {1}
			ivjBtnOk.setText(getOKString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBtnOk;
}
/**
 * Return the JCheckBox1 property value.
 * @return javax.swing.JCheckBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JCheckBox getChxAbstract() {
	if (ivjChxAbstract == null) {
		try {
			ivjChxAbstract = new javax.swing.JCheckBox();
			ivjChxAbstract.setName("ChxAbstract");
			ivjChxAbstract.setToolTipText("");
			ivjChxAbstract.setText("Abstrakt");
			// user code begin {1}
			ivjChxAbstract.setToolTipText(resClassDefDialog.getString("ChxAbstract_toolTipText"));
			ivjChxAbstract.setText(resClassDefDialog.getString("ChxAbstract_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjChxAbstract;
}
/**
 * Return the JCheckBox3 property value.
 * @return javax.swing.JCheckBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JCheckBox getChxFinal() {
	if (ivjChxFinal == null) {
		try {
			ivjChxFinal = new javax.swing.JCheckBox();
			ivjChxFinal.setName("ChxFinal");
			ivjChxFinal.setText("Final");
			ivjChxFinal.setEnabled(true);
			// user code begin {1}
			ivjChxFinal.setToolTipText(resClassDefDialog.getString("ChxFinal_toolTipText"));
			ivjChxFinal.setText(resClassDefDialog.getString("ChxFinal_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjChxFinal;
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
 * Return the JLabel1 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblKind() {
	if (ivjLblKind == null) {
		try {
			ivjLblKind = new javax.swing.JLabel();
			ivjLblKind.setName("LblKind");
			ivjLblKind.setText("Art:");
			ivjLblKind.setBounds(11, 14, 127, 14);
			// user code begin {1}
			ivjLblKind.setText(resClassDefDialog.getString("LblKind_text"));
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
 * Return the JLabel1 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblName() {
	if (ivjLblName == null) {
		try {
			ivjLblName = new javax.swing.JLabel();
			ivjLblName.setName("LblName");
			ivjLblName.setText("Name:");
			// user code begin {1}
			ivjLblName.setText(resClassDefDialog.getString("LblName_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLblName;
}
/**
 * Return the LocalColumnModelDefaultListSelectionModel property value.
 * @return javax.swing.DefaultListSelectionModel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.DefaultListSelectionModel getLocalColumnModelDefaultListSelectionModel() {
	javax.swing.DefaultListSelectionModel ivjLocalColumnModelDefaultListSelectionModel = null;
	try {
		/* Create part */
		ivjLocalColumnModelDefaultListSelectionModel = new javax.swing.DefaultListSelectionModel();
		ivjLocalColumnModelDefaultListSelectionModel.setAnchorSelectionIndex(0);
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	};
	return ivjLocalColumnModelDefaultListSelectionModel;
}
/**
 * Return the MniNewAttribute property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniNewAttribute() {
	if (ivjMniNewAttribute == null) {
		try {
			ivjMniNewAttribute = new javax.swing.JMenuItem();
			ivjMniNewAttribute.setName("MniNewAttribute");
			ivjMniNewAttribute.setText("Neu");
			ivjMniNewAttribute.setEnabled(true);
			// user code begin {1}
			ivjMniNewAttribute.setText(getNewString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniNewAttribute;
}
/**
 * Return the MniOpenAttributeSpecication property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniOpenAttributeSpecication() {
	if (ivjMniOpenAttributeSpecication == null) {
		try {
			ivjMniOpenAttributeSpecication = new javax.swing.JMenuItem();
			ivjMniOpenAttributeSpecication.setName("MniOpenAttributeSpecication");
			ivjMniOpenAttributeSpecication.setText("Oeffne Spezifikation...");
			ivjMniOpenAttributeSpecication.setEnabled(false);
			// user code begin {1}
			ivjMniOpenAttributeSpecication.setText(getChangeWindowString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniOpenAttributeSpecication;
}
/**
 * Return the MniRemoveAttribute property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniRemoveAttribute() {
	if (ivjMniRemoveAttribute == null) {
		try {
			ivjMniRemoveAttribute = new javax.swing.JMenuItem();
			ivjMniRemoveAttribute.setName("MniRemoveAttribute");
			ivjMniRemoveAttribute.setText("Loeschen");
			ivjMniRemoveAttribute.setEnabled(false);
			// user code begin {1}
			ivjMniRemoveAttribute.setText(getRemoveString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniRemoveAttribute;
}
/**
 * Return the JPopupMenu1 property value.
 * @return javax.swing.JPopupMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPopupMenu getMnuAttributes() {
	if (ivjMnuAttributes == null) {
		try {
			ivjMnuAttributes = new javax.swing.JPopupMenu();
			ivjMnuAttributes.setName("MnuAttributes");
			ivjMnuAttributes.add(getMniOpenAttributeSpecication());
			ivjMnuAttributes.add(getJSeparator1());
			ivjMnuAttributes.add(getMniNewAttribute());
			ivjMnuAttributes.add(getMniRemoveAttribute());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMnuAttributes;
}
/**
 * Return the JPanel2 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPnlAttributes() {
	if (ivjPnlAttributes == null) {
		try {
			ivjPnlAttributes = new javax.swing.JPanel();
			ivjPnlAttributes.setName("PnlAttributes");
			ivjPnlAttributes.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsScpAttributes = new java.awt.GridBagConstraints();
			constraintsScpAttributes.gridx = 1; constraintsScpAttributes.gridy = 1;
			constraintsScpAttributes.fill = java.awt.GridBagConstraints.BOTH;
			constraintsScpAttributes.weightx = 1.0;
			constraintsScpAttributes.weighty = 1.0;
			constraintsScpAttributes.ipadx = 356;
			constraintsScpAttributes.ipady = 95;
			constraintsScpAttributes.insets = new java.awt.Insets(7, 11, 6, 7);
			getPnlAttributes().add(getScpAttributes(), constraintsScpAttributes);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlAttributes;
}
/**
 * Return the PnlClassKind property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPnlClassKind() {
	if (ivjPnlClassKind == null) {
		try {
			ivjPnlClassKind = new javax.swing.JPanel();
			ivjPnlClassKind.setName("PnlClassKind");
			ivjPnlClassKind.setLayout(null);
			getPnlClassKind().add(getLblKind(), getLblKind().getName());
			getPnlClassKind().add(getRbtClass(), getRbtClass().getName());
			getPnlClassKind().add(getRbtStructure(), getRbtStructure().getName());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlClassKind;
}
/**
 * Return the PnlConstraints property value.
 * @return ch.ehi.umleditor.application.InterlisSyntaxPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private InterlisSyntaxPanel getPnlConstraints() {
	if (ivjPnlConstraints == null) {
		try {
			ivjPnlConstraints = new ch.ehi.umleditor.application.InterlisSyntaxPanel();
			ivjPnlConstraints.setName("PnlConstraints");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlConstraints;
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
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPnlDetail() {
	if (ivjPnlDetail == null) {
		try {
			ivjPnlDetail = new javax.swing.JPanel();
			ivjPnlDetail.setName("PnlDetail");
			ivjPnlDetail.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsChxAbstract = new java.awt.GridBagConstraints();
			constraintsChxAbstract.gridx = 1; constraintsChxAbstract.gridy = 1;
			constraintsChxAbstract.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsChxAbstract.ipadx = 119;
			constraintsChxAbstract.insets = new java.awt.Insets(12, 10, 1, 343);
			getPnlDetail().add(getChxAbstract(), constraintsChxAbstract);

			java.awt.GridBagConstraints constraintsChxFinal = new java.awt.GridBagConstraints();
			constraintsChxFinal.gridx = 1; constraintsChxFinal.gridy = 2;
			constraintsChxFinal.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsChxFinal.ipadx = 119;
			constraintsChxFinal.insets = new java.awt.Insets(1, 10, 3, 343);
			getPnlDetail().add(getChxFinal(), constraintsChxFinal);

			java.awt.GridBagConstraints constraintsPnlExtended = new java.awt.GridBagConstraints();
			constraintsPnlExtended.gridx = 1; constraintsPnlExtended.gridy = 3;
			constraintsPnlExtended.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsPnlExtended.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsPnlExtended.weightx = 1.0;
			constraintsPnlExtended.weighty = 1.0;
			constraintsPnlExtended.ipadx = 15;
			constraintsPnlExtended.ipady = 7;
			constraintsPnlExtended.insets = new java.awt.Insets(4, 10, 6, 18);
			getPnlDetail().add(getPnlExtended(), constraintsPnlExtended);

			java.awt.GridBagConstraints constraintsPnlClassKind = new java.awt.GridBagConstraints();
			constraintsPnlClassKind.gridx = 1; constraintsPnlClassKind.gridy = 4;
			constraintsPnlClassKind.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsPnlClassKind.weightx = 1.0;
			constraintsPnlClassKind.weighty = 1.0;
			constraintsPnlClassKind.ipadx = 442;
			constraintsPnlClassKind.ipady = 83;
			constraintsPnlClassKind.insets = new java.awt.Insets(6, 6, 58, 45);
			getPnlDetail().add(getPnlClassKind(), constraintsPnlClassKind);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlDetail;
}
/**
 * Return the JPanel MetaAttributes property value.
 * 
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPnlMetaAttributes() {
	if (ivjPnlMetaAttributes == null) {
		try {
			ivjPnlMetaAttributes = new javax.swing.JPanel();
			ivjPnlMetaAttributes.setName("PnlMetaAttributes");
			ivjPnlMetaAttributes.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsScpMetaAttributes = new java.awt.GridBagConstraints();
			constraintsScpMetaAttributes.gridx = 1;
			constraintsScpMetaAttributes.gridy = 1;
			constraintsScpMetaAttributes.fill = java.awt.GridBagConstraints.BOTH;
			constraintsScpMetaAttributes.weightx = 1.0;
			constraintsScpMetaAttributes.weighty = 1.0;
			constraintsScpMetaAttributes.ipadx = 356;
			constraintsScpMetaAttributes.ipady = 95;
			constraintsScpMetaAttributes.insets = new java.awt.Insets(7, 11, 6, 7);
			getPnlMetaAttributes().add(getScpMetaAttributes(), constraintsScpMetaAttributes);

			java.awt.GridBagConstraints constraintsBtnSave = new java.awt.GridBagConstraints();
			constraintsBtnSave.gridx = 1;
			constraintsBtnSave.gridy = 2;
			constraintsBtnSave.ipadx = 21;
			constraintsBtnSave.insets = new java.awt.Insets(6, 150, 12, 80);
			getPnlMetaAttributes().add(getBtnSaveMetaAttribuite(), constraintsBtnSave);

			java.awt.GridBagConstraints constraintsBtnAdd = new java.awt.GridBagConstraints();
			constraintsBtnAdd.gridx = 1;
			constraintsBtnAdd.gridy = 2;
			constraintsBtnAdd.ipadx = 18;
			constraintsBtnAdd.insets = new java.awt.Insets(6, 300, 12, 60);
			getPnlMetaAttributes().add(getBtnAddMetaAttribuite(), constraintsBtnAdd);
			java.awt.GridBagConstraints constraintsBtnDel = new java.awt.GridBagConstraints();
			constraintsBtnDel.gridx = 1;
			constraintsBtnDel.gridy = 2;
			constraintsBtnDel.ipadx = 15;
			constraintsBtnDel.insets = new java.awt.Insets(6, 450, 12, 40);
			getPnlMetaAttributes().add(getBtnDeleteMetaAttribuite(), constraintsBtnDel);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlMetaAttributes;
}
private javax.swing.JScrollPane getScpMetaAttributes() {
	if (ivjScpMetaAttributes == null) {
		try {
			ivjScpMetaAttributes = new javax.swing.JScrollPane();
			ivjScpMetaAttributes.setName("ScpMetaAttributes");
			ivjScpMetaAttributes.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			ivjScpMetaAttributes
					.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			getScpMetaAttributes().setViewportView(getTblMetaAttributes());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScpMetaAttributes;
}
private javax.swing.table.TableColumn getTbcMetaAttributeName() {
	if (ivjTbcMetaAttributeName == null) {
		try {
			ivjTbcMetaAttributeName = new javax.swing.table.TableColumn();
			ivjTbcMetaAttributeName.setHeaderValue(resClassDefDialog.getString("LblColMetaAttrKey_text"));
			// user code begin {1}
			// ivjTbcMetaAttributeName.setHeaderValue(resClassDefDialog.getString("TbcMetaAttributeName_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcMetaAttributeName;
}

private javax.swing.JButton getBtnSaveMetaAttribuite() {
	if (ivjBtnSaveMetaAttribute == null) {
		try {
			ivjBtnSaveMetaAttribute = new javax.swing.JButton();
			ivjBtnSaveMetaAttribute.setName("BtnSavMetaAttribute");
			ivjBtnSaveMetaAttribute.setText("Save");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBtnSaveMetaAttribute;
}
private javax.swing.JButton getBtnAddMetaAttribuite() {
	if (ivjBtnAddMetaAttribute == null) {
		try {
			ivjBtnAddMetaAttribute = new javax.swing.JButton();
			ivjBtnAddMetaAttribute.setName("BtnAddMetaAttribute");
			ivjBtnAddMetaAttribute.setText("Add");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBtnAddMetaAttribute;
}
private javax.swing.JButton getBtnDeleteMetaAttribuite() {
	if (ivjBtnDeleteMetaAttribute == null) {
		try {
			ivjBtnDeleteMetaAttribute = new javax.swing.JButton();
			ivjBtnDeleteMetaAttribute.setName("BtnDelMetaAttribute");
			ivjBtnDeleteMetaAttribute.setText("Delete");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBtnDeleteMetaAttribute;
}
private javax.swing.table.TableColumn getTbcMetaAttributeValue() {
	if (ivjTbcMetaAttributeValue == null) {
		try {
			ivjTbcMetaAttributeValue = new javax.swing.table.TableColumn();
			ivjTbcMetaAttributeValue.setHeaderValue(resClassDefDialog.getString("LblColMetaAttrValue_text"));
			// user code begin {1}
			// ivjTbcMetaAttributeValue.setHeaderValue(resClassDefDialog.getString("TbcAttribueValue_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcMetaAttributeValue;
}
private javax.swing.JTable getTblMetaAttributes() {
	if (ivjTblMetaAttributes == null) {
		try {
			javax.swing.table.DefaultTableColumnModel ivjLocalColumnModel;
			ivjLocalColumnModel = new javax.swing.table.DefaultTableColumnModel();
			ivjLocalColumnModel.setSelectionModel(getLocalColumnModelDefaultListSelectionModel());
			ivjTblMetaAttributes = new javax.swing.JTable();
			ivjTblMetaAttributes.setName("TblMetaAttributes");
			getScpMetaAttributes().setColumnHeaderView(ivjTblMetaAttributes.getTableHeader());
			getScpMetaAttributes().getViewport().setBackingStoreEnabled(true);
			ivjTblMetaAttributes.setCellSelectionEnabled(false);
			ivjTblMetaAttributes.setColumnModel(ivjLocalColumnModel);
			ivjTblMetaAttributes.setBounds(0, 0, 200, 200);
			ivjTblMetaAttributes.setRowSelectionAllowed(true);
			ivjTblMetaAttributes.setEnabled(true);
			ivjTblMetaAttributes.setModel(objTableMetaAttribute.getTableModel());
			objTableMetaAttribute.addCol(getTbcMetaAttributeName().getHeaderValue(),
					getTbcMetaAttributeValue().getHeaderValue());
			ivjTblMetaAttributes.setSelectionModel(objSelectionMetaAttribute);
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTblMetaAttributes;
}
/**
 * Return the PnlExtended property value.
 * @return ch.ehi.umleditor.application.ExtendedPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private ExtendedPanel getPnlExtended() {
	if (ivjPnlExtended == null) {
		try {
			ivjPnlExtended = new ch.ehi.umleditor.application.ExtendedPanel();
			ivjPnlExtended.setName("PnlExtended");
			ivjPnlExtended.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlExtended;
}
/**
 * Return the PnlParameters property value.
 * @return ch.ehi.umleditor.application.InterlisSyntaxPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private InterlisSyntaxPanel getPnlParameters() {
	if (ivjPnlParameters == null) {
		try {
			ivjPnlParameters = new ch.ehi.umleditor.application.InterlisSyntaxPanel();
			ivjPnlParameters.setName("PnlParameters");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlParameters;
}
/**
 * Return the RbtClass property value.
 * @return javax.swing.JRadioButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JRadioButton getRbtClass() {
	if (ivjRbtClass == null) {
		try {
			ivjRbtClass = new javax.swing.JRadioButton();
			ivjRbtClass.setName("RbtClass");
			ivjRbtClass.setText("Klasse");
			ivjRbtClass.setBounds(155, 11, 239, 21);
			// user code begin {1}
			ivjRbtClass.setText(resClassDefDialog.getString("RbtClass_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRbtClass;
}
/**
 * Return the RbtStructure property value.
 * @return javax.swing.JRadioButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JRadioButton getRbtStructure() {
	if (ivjRbtStructure == null) {
		try {
			ivjRbtStructure = new javax.swing.JRadioButton();
			ivjRbtStructure.setName("RbtStructure");
			ivjRbtStructure.setText("Struktur");
			ivjRbtStructure.setBounds(155, 41, 239, 21);
			// user code begin {1}
			ivjRbtStructure.setText(resClassDefDialog.getString("RbtStructure_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRbtStructure;
}
/**
 * Return the JScrollPane1 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getScpAttributes() {
	if (ivjScpAttributes == null) {
		try {
			ivjScpAttributes = new javax.swing.JScrollPane();
			ivjScpAttributes.setName("ScpAttributes");
			ivjScpAttributes.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			ivjScpAttributes.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			getScpAttributes().setViewportView(getTblAttributes());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScpAttributes;
}
/**
 * Return the TableColumn1 property value.
 * @return javax.swing.table.TableColumn
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.table.TableColumn getTbcAttributeName() {
	if (ivjTbcAttributeName == null) {
		try {
			ivjTbcAttributeName = new javax.swing.table.TableColumn();
			ivjTbcAttributeName.setHeaderValue("Name");
			// user code begin {1}
			ivjTbcAttributeName.setHeaderValue(resClassDefDialog.getString("TbcAttributeName_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcAttributeName;
}
/**
 * Return the TableColumn2 property value.
 * @return javax.swing.table.TableColumn
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.table.TableColumn getTbcAttributeType() {
	if (ivjTbcAttributeType == null) {
		try {
			ivjTbcAttributeType = new javax.swing.table.TableColumn();
			ivjTbcAttributeType.setHeaderValue("Typ");
			// user code begin {1}
			ivjTbcAttributeType.setHeaderValue(resClassDefDialog.getString("TbcAttribueType_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcAttributeType;
}
/**
 * Return the ScrollPaneTable property value.
 * @return javax.swing.JTable
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTable getTblAttributes() {
	if (ivjTblAttributes == null) {
		try {
			javax.swing.table.DefaultTableColumnModel ivjLocalColumnModel;
			ivjLocalColumnModel = new javax.swing.table.DefaultTableColumnModel();
			ivjLocalColumnModel.setSelectionModel(getLocalColumnModelDefaultListSelectionModel());
			ivjTblAttributes = new javax.swing.JTable();
			ivjTblAttributes.setName("TblAttributes");
			getScpAttributes().setColumnHeaderView(ivjTblAttributes.getTableHeader());
			getScpAttributes().getViewport().setBackingStoreEnabled(true);
			ivjTblAttributes.setCellSelectionEnabled(false);
			ivjTblAttributes.setColumnModel(ivjLocalColumnModel);
			ivjTblAttributes.setBounds(0, 0, 200, 200);
			ivjTblAttributes.setRowSelectionAllowed(true);
			ivjTblAttributes.setEnabled(true);
			ivjTblAttributes.addColumn(getTbcAttributeName());
			ivjTblAttributes.addColumn(getTbcAttributeType());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTblAttributes;
}
/**
 * Return the TbpGeneral property value.
 * @return javax.swing.JTabbedPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTabbedPane getTbpGeneral() {
	if (ivjTbpGeneral == null) {
		try {
			ivjTbpGeneral = new javax.swing.JTabbedPane();
			ivjTbpGeneral.setName("TbpGeneral");
			ivjTbpGeneral.insertTab(getDescriptionString(), null, getPnlDescription(), null, 0);
			ivjTbpGeneral.insertTab(getDetailString(), null, getPnlDetail(), null, 1);
			ivjTbpGeneral.insertTab(resClassDefDialog.getString("TbpMetaAttributes_text"), null, getPnlMetaAttributes(), null, 2);
			ivjTbpGeneral.insertTab(resClassDefDialog.getString("TbpAttributes_text"), null, getPnlAttributes(), null, 3);
			ivjTbpGeneral.insertTab(resClassDefDialog.getString("TbpParameter_text"), null, getPnlParameters(), null, 4);
			ivjTbpGeneral.insertTab(resClassDefDialog.getString("TbpConstraints_text"), null, getPnlConstraints(), null, 5);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbpGeneral;
}
/**
 * Return the JTextField1 property value.
 * @return javax.swing.JTextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getTxtName() {
	if (ivjTxtName == null) {
		try {
			ivjTxtName = new javax.swing.JTextField();
			ivjTxtName.setName("TxtName");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTxtName;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
protected void handleException(java.lang.Throwable exception) {
	super.handleException(exception);
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getBtnOk().addActionListener(ivjEventHandler);
	getBtnCancel().addActionListener(ivjEventHandler);
	getBtnApply().addActionListener(ivjEventHandler);
	getScpAttributes().addMouseListener(ivjEventHandler);
	getMniNewAttribute().addActionListener(ivjEventHandler);
	getMniRemoveAttribute().addActionListener(ivjEventHandler);
	getTblAttributes().addMouseListener(ivjEventHandler);
	getMniOpenAttributeSpecication().addActionListener(ivjEventHandler);
	getTxtName().addFocusListener(ivjEventHandler);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("ClassDefDialog");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(527, 404);
		setTitle("Klasse");
		setContentPane(getBaseDialogContentPane());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	setTitle(resClassDefDialog.getString("CTDialog"));
	javax.swing.ButtonGroup buttonGroup = new javax.swing.ButtonGroup();
	buttonGroup.add(getRbtClass());
	buttonGroup.add(getRbtStructure());

        mniMoveDownAttribute=new javax.swing.JMenuItem();
	mniMoveDownAttribute.setText(resClassDefDialog.getString("MniMoveDown_text"));
	mniMoveDownAttribute.addActionListener(new java.awt.event.ActionListener() {
	  // callback handler if menu item was selected
	  public void actionPerformed(java.awt.event.ActionEvent e) {
		mniMoveDownAttribute();
	  }
	});
	getMnuAttributes().add(mniMoveDownAttribute);

	// user code end
}
/**
 * @deprecated
 */
private void mniNewAttribute() {
	newObject(null);
}
/**
 * @deprecated
 */
private void mniRemoveAttribute() {
	removeObjects(null);
}
private void mniRemoveMetaAttribute() {
	removeMetaObjects();
}

private void mniSaveMetaAttribute() {
	saveMetaAttribute();
}
/**
 * Move down selected Attribute in Attributes-List.
 */
private void mniMoveDownAttribute() {
   int [] selv=getTblAttributes().getSelectedRows();
   if(selv.length>0){
 	((EditorTableModel)getTblAttributes().getModel()).moveRowDown(selv[0]);
   }
}

/**
 * @deprecated
 */
private void mniShowAttributeSpecification() {
	changeObjects(getTblAttributes());
}
/**
 * Save ModelElement changes.
 * @see setElement()
 * @see initialize()
 * @see okPressed()
 * @see applyPressed
 */
protected boolean save() {
	// general & page Description
	if (!ElementUtils.trySetName(classDef, getTxtName().getText())) {
		return false;
	}
	if (getRbtClass().isSelected()) {
		classDef.setKind(ClassDefKind.CLASS);
	} else if (getRbtStructure().isSelected()) {
			classDef.setKind(ClassDefKind.STRUCTURE);
	} else {
		Tracer.getInstance().developerWarning("ClassDef.kind not properly initialized");//$NON-NLS-2$//$NON-NLS-1$
	}
	getPnlDescription().getObject();

	// page Detail
	classDef.setAbstract(getChxAbstract().isSelected());
	classDef.setPropFinal(getChxFinal().isSelected());
	if (!getPnlExtended().getClassifierExtension(getTxtName().getText())) {
		return false;
	}

	// page Constraints
	getPnlConstraints().getConstraints();

	// page ParameterDef
	getPnlParameters().getParameterDefs();

	return super.save();
}
/**
 * Map model to view.
 * @see initialize()
 * @see save()
 */
private void setElement(ch.ehi.uml1_4.foundation.core.Element element) {
	classDef = (ClassDef)element;

	// general & page Description
	getTxtName().setText(classDef.getDefLangName());
	getPnlDescription().setObject(element);
	switch (classDef.getKind()) {
		case ClassDefKind.CLASS: {
			getRbtClass().setSelected(true);
			break;
		}
		case ClassDefKind.STRUCTURE: {
			getRbtStructure().setSelected(true);
			break;
		}
	}

	// page Detail
	getChxAbstract().setSelected(classDef.isAbstract());
	getChxFinal().setSelected(classDef.isPropFinal());
	getPnlExtended().setClassifierExtension(classDef);

	// page Attributes
	getTblAttributes().setModel(new EditorTableModel());
	((EditorTableModel)getTblAttributes().getModel()).setAttributeDef(classDef);

	// page Constraints
	getPnlConstraints().setConstraints(classDef);

	// page ParameterDef
	getPnlParameters().setParameterDefs(classDef);
}
/**
 * @see ch.softenvironment.view.ListMenuChoice#changeObjects(java.lang.Object)
 */
public void changeObjects(Object source) {
	try {
		if ((source != null) && (source.equals(getMnuAttributes()) || source.equals(getTblAttributes()))) {
			((EditorTableModel)getTblAttributes().getModel()).showSpecification(getTblAttributes().getSelectedRows());
		}
	} catch(Throwable e) {
		handleException(e);
	}
}
/**
 * @see ch.softenvironment.view.ListMenuChoice#copyObject(java.lang.Object)
 */
public void copyObject(Object source) {
	// TODO Auto-generated method stub
	
}
/** 
 * @see ch.softenvironment.view.ListMenuChoice#newObject(java.lang.Object)
 */
public void newObject(Object source) {
	try {
		// update model
		AttributeDef attributeDef = ElementFactory.createAttributeDef(classDef);
		// update view
		((EditorTableModel)getTblAttributes().getModel()).addRowElement(attributeDef);
	} catch(Throwable e) {
		handleException(e);
	}
}
public void newMetaObject() {
	try {
		objTableMetaAttribute.addRow("MetaAttribute", "0");

	} catch (Throwable e) {
		handleException(e);
	}
}
/**
 * @see ch.softenvironment.view.ListMenuChoice#removeObjects(java.lang.Object)
 */
public void removeObjects(Object source) {
	((EditorTableModel)getTblAttributes().getModel()).removeRows(getTblAttributes().getSelectedRows());
}

public void removeMetaObjects() {
	try {
		String valorDelete = ivjTblMetaAttributes.getValueAt(ivjTblMetaAttributes.getSelectedRow(), 0).toString();
		objTableMetaAttribute.removeRow(ivjTblMetaAttributes.getSelectedRow());

		Iterator<?> it = classDef.iteratorTaggedValue();
		while (it.hasNext()) {
			ivjTaggedValue = (TaggedValue) it.next();
			if (ivjTaggedValue.getName().getValue().equals("ili:" + valorDelete)) {
				//classDef.removeTaggedValue(ivjTaggedValue);
				it.remove();
			}
		}
		

	} catch (java.lang.ArrayIndexOutOfBoundsException e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "Select the name of the row to be deleted");
	} catch (java.util.ConcurrentModificationException ex) {
		// Nothing to do
	}
}
public void saveMetaAttribute() {
	for (int i = 0; i < ivjTblMetaAttributes.getRowCount(); i++) {
		ivjTaggedValue = (ch.ehi.uml1_4.foundation.extensionmechanisms.TaggedValue) ElementFactory
				.createObject(ch.ehi.uml1_4.implementation.UmlTaggedValue.class);
		String nameValue = ivjTblMetaAttributes.getValueAt(i, 0).toString();
		if (nameValue.contains(":") || nameValue.contains(" ")) {
			JOptionPane.showMessageDialog(null, "Caracter invalido : o espacio no es permitido");
			break;
		} else {
			ivjTaggedValue.setName(new NlsString(TaggedValue.TAGGEDVALUE_LANG, "ili:" + nameValue));
			String value = ivjTblMetaAttributes.getValueAt(i, 1).toString();
			ivjTaggedValue.setDataValue(value);
			classDef.addTaggedValue(ivjTaggedValue);
		}

	}
}
}
