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
import java.util.*;
import ch.ehi.interlis.modeltopicclass.*;
import ch.softenvironment.view.*;
/**
 * User Interface for a ModelDef.
 * 
 * @author: Peter Hirzel <i>soft</i>Environment 
 * @version $Revision: 1.1.1.1 $ $Date: 2003-12-23 10:39:36 $
 */
public class ModelDefDialog extends BaseDialog {
	// ModelElement
	private static java.util.ResourceBundle resModelDefDialog = java.util.ResourceBundle.getBundle("ch/ehi/umleditor/application/resources/ModelDefDialog");  //$NON-NLS-1$
	private ModelDef modelDef = null;
	private Translation currentTranslation = null;
	private javax.swing.JPanel ivjBaseDialogContentPane = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private javax.swing.JButton ivjBtnCancel = null;
	private javax.swing.JButton ivjBtnOk = null;
	private javax.swing.JTabbedPane ivjTbpGeneral = null;
	private javax.swing.JLabel ivjLblName = null;
	private javax.swing.JTextField ivjTxtName = null;
	private javax.swing.JButton ivjBtnApply = null;
	private javax.swing.JComboBox ivjCbxType = null;
	private DescriptionPanel ivjPnlDescription = null;
	private javax.swing.JComboBox ivjCbxLanguage = null;
	private javax.swing.JLabel ivjLblLanguage = null;
	private javax.swing.JLabel ivjLblTranslation = null;
	private javax.swing.JPanel ivjPnlContract = null;
	private javax.swing.JPanel ivjPnlImport = null;
	private javax.swing.JScrollPane ivjScpContract = null;
	private javax.swing.table.TableColumn ivjTbcIssuer = null;
	private javax.swing.JTable ivjTblContract = null;
	private javax.swing.JSeparator ivjJSeparator1 = null;
	private javax.swing.JMenuItem ivjMniOpenContractSpecification = null;
	private javax.swing.JMenuItem ivjMniRemoveContract = null;
	private javax.swing.JMenuItem ivjMniNewContract = null;
	private javax.swing.JMenuItem ivjMniOpenImportSpecification = null;
	private javax.swing.JPopupMenu ivjMnuContract = null;
	private javax.swing.JPopupMenu ivjMnuImport = null;
	private javax.swing.JSeparator ivjJSeparator11 = null;
	private javax.swing.JMenuItem ivjMniNewImport = null;
	private javax.swing.JMenuItem ivjMniRemoveImport = null;
	private javax.swing.JScrollPane ivjScpDependency = null;
	private javax.swing.table.TableColumn ivjTbcModelDefName = null;
	private javax.swing.JTable ivjTblImport = null;
	private javax.swing.table.TableColumn ivjTbcBaseLanguage = null;
	private javax.swing.table.TableColumn ivjTbcLanguage = null;
	private javax.swing.JScrollPane ivjScpTranslation = null;
	private javax.swing.JTable ivjTblTranslation = null;
	private javax.swing.JSeparator ivjJSeparator12 = null;
	private javax.swing.JMenuItem ivjMniNewTranslation = null;
	private javax.swing.JMenuItem ivjMniOpenTranslationSpecification = null;
	private javax.swing.JMenuItem ivjMniRemoveTranslation = null;
	private javax.swing.JPopupMenu ivjMnuTranslation = null;
	private javax.swing.JLabel ivjLblType = null;
	private javax.swing.JPanel ivjPnlDetail = null;

class IvjEventHandler implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.MouseListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == ModelDefDialog.this.getBtnOk()) 
				connEtoC1(e);
			if (e.getSource() == ModelDefDialog.this.getBtnCancel()) 
				connEtoC2(e);
			if (e.getSource() == ModelDefDialog.this.getBtnApply()) 
				connEtoC3(e);
			if (e.getSource() == ModelDefDialog.this.getMniRemoveContract()) 
				connEtoC6(e);
			if (e.getSource() == ModelDefDialog.this.getMniNewContract()) 
				connEtoC7(e);
			if (e.getSource() == ModelDefDialog.this.getMniOpenContractSpecification()) 
				connEtoC8(e);
			if (e.getSource() == ModelDefDialog.this.getMniOpenImportSpecification()) 
				connEtoC9(e);
			if (e.getSource() == ModelDefDialog.this.getMniRemoveImport()) 
				connEtoC13(e);
			if (e.getSource() == ModelDefDialog.this.getMniNewImport()) 
				connEtoC12(e);
			if (e.getSource() == ModelDefDialog.this.getMniOpenTranslationSpecification()) 
				connEtoC16(e);
			if (e.getSource() == ModelDefDialog.this.getMniNewTranslation()) 
				connEtoC17(e);
			if (e.getSource() == ModelDefDialog.this.getMniRemoveTranslation()) 
				connEtoC18(e);
		};
		public void focusGained(java.awt.event.FocusEvent e) {
			if (e.getSource() == ModelDefDialog.this.getTxtName()) 
				connEtoM1(e);
		};
		public void focusLost(java.awt.event.FocusEvent e) {};
		public void mouseClicked(java.awt.event.MouseEvent e) {};
		public void mouseEntered(java.awt.event.MouseEvent e) {};
		public void mouseExited(java.awt.event.MouseEvent e) {};
		public void mousePressed(java.awt.event.MouseEvent e) {
			if (e.getSource() == ModelDefDialog.this.getScpTranslation()) 
				connEtoC19(e);
			if (e.getSource() == ModelDefDialog.this.getTblTranslation()) 
				connEtoC20(e);
			if (e.getSource() == ModelDefDialog.this.getScpContract()) 
				connEtoC21(e);
			if (e.getSource() == ModelDefDialog.this.getTblContract()) 
				connEtoC22(e);
			if (e.getSource() == ModelDefDialog.this.getScpDependency()) 
				connEtoC23(e);
			if (e.getSource() == ModelDefDialog.this.getTblImport()) 
				connEtoC24(e);
		};
		public void mouseReleased(java.awt.event.MouseEvent e) {
			if (e.getSource() == ModelDefDialog.this.getScpContract()) 
				connEtoC4(e);
			if (e.getSource() == ModelDefDialog.this.getTblContract()) 
				connEtoC5(e);
			if (e.getSource() == ModelDefDialog.this.getScpDependency()) 
				connEtoC10(e);
			if (e.getSource() == ModelDefDialog.this.getTblImport()) 
				connEtoC11(e);
			if (e.getSource() == ModelDefDialog.this.getScpTranslation()) 
				connEtoC14(e);
			if (e.getSource() == ModelDefDialog.this.getTblTranslation()) 
				connEtoC15(e);
		};
	};
/**
 * Constructor
 */
public ModelDefDialog(java.awt.Frame owner, ch.ehi.uml1_4.foundation.core.Element element) {
	super(owner, true);
	initialize();
	setRelativeLocation(owner);
	setElement(element);
	show();
}
/**
 * Adapt the given PopupMenu before displaying it (for e.g. disable Items).
 */
protected void adaptPopupMenu(javax.swing.JPopupMenu popupMenu) {
	boolean isSelected = getTblTranslation().getSelectedRow() >= 0;
	getMniOpenTranslationSpecification().setEnabled(isSelected);
	getMniRemoveTranslation().setEnabled(isSelected);
	
	isSelected = getTblContract().getSelectedRow() >= 0;
	getMniOpenContractSpecification().setEnabled(isSelected);
	getMniRemoveContract().setEnabled(isSelected);

	isSelected = getTblImport().getSelectedRow() >= 0;
	getMniOpenImportSpecification().setEnabled(isSelected);
	getMniRemoveImport().setEnabled(isSelected);
}
/**
 * connEtoC1:  (BtnOk.action.actionPerformed(java.awt.event.ActionEvent) --> UmlModelDialog.okPressed()V)
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
 * connEtoC10:  (ScpModelDef.mouse.mouseReleased(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC10(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuImport());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC11:  (TblImport.mouse.mouseReleased(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC11(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuImport());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC12:  (MniNewImport.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniNewImport()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC12(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniNewImport();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC13:  (MniRemoveImport.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniRemoveImport()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC13(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniRemoveImport();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC14:  (ScpTranslation.mouse.mouseReleased(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC14(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuTranslation());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC15:  (TblTranslation.mouse.mouseReleased(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC15(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuTranslation());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC16:  (MniOpenTranslationSpecification.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniOpenTranslationSpecification()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC16(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniOpenTranslationSpecification();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC17:  (MniNewTranslation.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniNewTranslation()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC17(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniNewTranslation();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC18:  (MniRemoveTranslation.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniRemoveTranslation()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC18(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniRemoveTranslation();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC19:  (ScpTranslation.mouse.mousePressed(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC19(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuTranslation());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (BtnCancel.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.cancelPressed()V)
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
 * connEtoC20:  (TblTranslation.mouse.mousePressed(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC20(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuTranslation());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC21:  (ScpContract.mouse.mousePressed(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC21(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuContract());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC22:  (TblContract.mouse.mousePressed(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC22(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuContract());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC23:  (ScpDependency.mouse.mousePressed(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC23(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuImport());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC24:  (TblImport.mouse.mousePressed(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC24(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuImport());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (BtnApply.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.applyPressed()V)
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
 * connEtoC4:  (ScpContract.mouse.mouseReleased(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuContract());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (TblContract.mouse.mouseReleased(java.awt.event.MouseEvent) --> ModelDefDialog.genericPopupDisplay(Ljava.awt.event.MouseEvent;Ljavax.swing.JPopupMenu;)V)
 * @param arg1 java.awt.event.MouseEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.awt.event.MouseEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.genericPopupDisplay(arg1, getMnuContract());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (MniRemoveAttribute.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniRemoveAttribute()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniRemoveContract();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC7:  (MniNewAttribute.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniNewContract()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC7(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniNewContract();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC8:  (MniOpenContractSpecification.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniOpenContractSpecification()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC8(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniOpenContractSpecification();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC9:  (MniOpenImportSpecification.action.actionPerformed(java.awt.event.ActionEvent) --> ModelDefDialog.mniOpenImportSpecification()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC9(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.mniOpenImportSpecification();
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
			constraintsLblName.gridx = 0; constraintsLblName.gridy = 0;
			constraintsLblName.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsLblName.ipadx = 104;
			constraintsLblName.insets = new java.awt.Insets(22, 10, 4, 9);
			getBaseDialogContentPane().add(getLblName(), constraintsLblName);

			java.awt.GridBagConstraints constraintsTxtName = new java.awt.GridBagConstraints();
			constraintsTxtName.gridx = 1; constraintsTxtName.gridy = 0;
			constraintsTxtName.gridwidth = 2;
			constraintsTxtName.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTxtName.weightx = 1.0;
			constraintsTxtName.ipadx = 246;
			constraintsTxtName.insets = new java.awt.Insets(19, 2, 1, 15);
			getBaseDialogContentPane().add(getTxtName(), constraintsTxtName);

			java.awt.GridBagConstraints constraintsTbpGeneral = new java.awt.GridBagConstraints();
			constraintsTbpGeneral.gridx = 0; constraintsTbpGeneral.gridy = 2;
			constraintsTbpGeneral.gridwidth = 3;
			constraintsTbpGeneral.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTbpGeneral.weightx = 1.0;
			constraintsTbpGeneral.weighty = 1.0;
			constraintsTbpGeneral.insets = new java.awt.Insets(3, 13, 4, 12);
			getBaseDialogContentPane().add(getTbpGeneral(), constraintsTbpGeneral);

			java.awt.GridBagConstraints constraintsLblType = new java.awt.GridBagConstraints();
			constraintsLblType.gridx = 0; constraintsLblType.gridy = 1;
			constraintsLblType.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsLblType.ipadx = 117;
			constraintsLblType.insets = new java.awt.Insets(5, 10, 8, 9);
			getBaseDialogContentPane().add(getLblType(), constraintsLblType);

			java.awt.GridBagConstraints constraintsCbxType = new java.awt.GridBagConstraints();
			constraintsCbxType.gridx = 1; constraintsCbxType.gridy = 1;
			constraintsCbxType.gridwidth = 2;
			constraintsCbxType.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsCbxType.weightx = 1.0;
			constraintsCbxType.ipadx = 40;
			constraintsCbxType.insets = new java.awt.Insets(1, 2, 3, 99);
			getBaseDialogContentPane().add(getCbxType(), constraintsCbxType);

			java.awt.GridBagConstraints constraintsBtnOk = new java.awt.GridBagConstraints();
			constraintsBtnOk.gridx = 0; constraintsBtnOk.gridy = 3;
			constraintsBtnOk.ipadx = 64;
			constraintsBtnOk.insets = new java.awt.Insets(4, 42, 10, 2);
			getBaseDialogContentPane().add(getBtnOk(), constraintsBtnOk);

			java.awt.GridBagConstraints constraintsBtnCancel = new java.awt.GridBagConstraints();
			constraintsBtnCancel.gridx = 1; constraintsBtnCancel.gridy = 3;
			constraintsBtnCancel.ipadx = 18;
			constraintsBtnCancel.insets = new java.awt.Insets(4, 4, 10, 3);
			getBaseDialogContentPane().add(getBtnCancel(), constraintsBtnCancel);

			java.awt.GridBagConstraints constraintsBtnApply = new java.awt.GridBagConstraints();
			constraintsBtnApply.gridx = 2; constraintsBtnApply.gridy = 3;
			constraintsBtnApply.ipadx = 8;
			constraintsBtnApply.insets = new java.awt.Insets(4, 3, 10, 27);
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
			ivjBtnApply.setText("�bernehmen");
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
 * Return the JComboBox1 property value.
 * @return javax.swing.JComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JComboBox getCbxLanguage() {
	if (ivjCbxLanguage == null) {
		try {
			ivjCbxLanguage = new javax.swing.JComboBox();
			ivjCbxLanguage.setName("CbxLanguage");
			ivjCbxLanguage.setEditable(true);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCbxLanguage;
}
/**
 * Return the JComboBox11 property value.
 * @return javax.swing.JComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JComboBox getCbxType() {
	if (ivjCbxType == null) {
		try {
			ivjCbxType = new javax.swing.JComboBox();
			ivjCbxType.setName("CbxType");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCbxType;
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
 * Return the JSeparator11 property value.
 * @return javax.swing.JSeparator
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JSeparator getJSeparator11() {
	if (ivjJSeparator11 == null) {
		try {
			ivjJSeparator11 = new javax.swing.JSeparator();
			ivjJSeparator11.setName("JSeparator11");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJSeparator11;
}
/**
 * Return the JSeparator12 property value.
 * @return javax.swing.JSeparator
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JSeparator getJSeparator12() {
	if (ivjJSeparator12 == null) {
		try {
			ivjJSeparator12 = new javax.swing.JSeparator();
			ivjJSeparator12.setName("JSeparator12");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJSeparator12;
}
/**
 * Return the JLabel1 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblLanguage() {
	if (ivjLblLanguage == null) {
		try {
			ivjLblLanguage = new javax.swing.JLabel();
			ivjLblLanguage.setName("LblLanguage");
			ivjLblLanguage.setText("Original-Sprache:");
			// user code begin {1}
			ivjLblLanguage.setText(resModelDefDialog.getString("LblLanguage_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLblLanguage;
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
			ivjLblName.setText(resModelDefDialog.getString("LblName_text"));
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
 * Return the JLabel12 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblTranslation() {
	if (ivjLblTranslation == null) {
		try {
			ivjLblTranslation = new javax.swing.JLabel();
			ivjLblTranslation.setName("LblTranslation");
			ivjLblTranslation.setText("�bersetzung:");
			// user code begin {1}
			ivjLblTranslation.setText(resModelDefDialog.getString("LblTranslation_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLblTranslation;
}
/**
 * Return the JLabel11 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getLblType() {
	if (ivjLblType == null) {
		try {
			ivjLblType = new javax.swing.JLabel();
			ivjLblType.setName("LblType");
			ivjLblType.setText("Typ:");
			// user code begin {1}
			ivjLblType.setText(resModelDefDialog.getString("LblType_text"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLblType;
}
/**
 * Return the MniNewAttribute property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniNewContract() {
	if (ivjMniNewContract == null) {
		try {
			ivjMniNewContract = new javax.swing.JMenuItem();
			ivjMniNewContract.setName("MniNewContract");
			ivjMniNewContract.setText("Neu");
			ivjMniNewContract.setEnabled(true);
			// user code begin {1}
			ivjMniNewContract.setText(getNewString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniNewContract;
}
/**
 * Return the MniNewImport property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniNewImport() {
	if (ivjMniNewImport == null) {
		try {
			ivjMniNewImport = new javax.swing.JMenuItem();
			ivjMniNewImport.setName("MniNewImport");
			ivjMniNewImport.setText("Neu");
			ivjMniNewImport.setEnabled(true);
			// user code begin {1}
			ivjMniNewImport.setText(getNewString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniNewImport;
}
/**
 * Return the MniNewTranslation property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniNewTranslation() {
	if (ivjMniNewTranslation == null) {
		try {
			ivjMniNewTranslation = new javax.swing.JMenuItem();
			ivjMniNewTranslation.setName("MniNewTranslation");
			ivjMniNewTranslation.setText("Neu");
			ivjMniNewTranslation.setEnabled(true);
			// user code begin {1}
			ivjMniNewTranslation.setText(getNewString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniNewTranslation;
}
/**
 * Return the MniOpenAttributeSpecication property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniOpenContractSpecification() {
	if (ivjMniOpenContractSpecification == null) {
		try {
			ivjMniOpenContractSpecification = new javax.swing.JMenuItem();
			ivjMniOpenContractSpecification.setName("MniOpenContractSpecification");
			ivjMniOpenContractSpecification.setText("�ffne Spezifikation...");
			ivjMniOpenContractSpecification.setEnabled(false);
			// user code begin {1}
			ivjMniOpenContractSpecification.setText(getChangeWindowString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniOpenContractSpecification;
}
/**
 * Return the MniOpenImportSpecification property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniOpenImportSpecification() {
	if (ivjMniOpenImportSpecification == null) {
		try {
			ivjMniOpenImportSpecification = new javax.swing.JMenuItem();
			ivjMniOpenImportSpecification.setName("MniOpenImportSpecification");
			ivjMniOpenImportSpecification.setText("�ffne Spezifikation...");
			ivjMniOpenImportSpecification.setEnabled(false);
			// user code begin {1}
			ivjMniOpenImportSpecification.setText(getChangeWindowString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniOpenImportSpecification;
}
/**
 * Return the MniOpenTranslationSpecification property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniOpenTranslationSpecification() {
	if (ivjMniOpenTranslationSpecification == null) {
		try {
			ivjMniOpenTranslationSpecification = new javax.swing.JMenuItem();
			ivjMniOpenTranslationSpecification.setName("MniOpenTranslationSpecification");
			ivjMniOpenTranslationSpecification.setText("�ffne Spezifikation...");
			ivjMniOpenTranslationSpecification.setEnabled(false);
			// user code begin {1}
			ivjMniOpenTranslationSpecification.setText(getChangeWindowString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniOpenTranslationSpecification;
}
/**
 * Return the MniRemoveAttribute property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniRemoveContract() {
	if (ivjMniRemoveContract == null) {
		try {
			ivjMniRemoveContract = new javax.swing.JMenuItem();
			ivjMniRemoveContract.setName("MniRemoveContract");
			ivjMniRemoveContract.setText("L�schen");
			ivjMniRemoveContract.setEnabled(false);
			// user code begin {1}
			ivjMniRemoveContract.setText(getRemoveString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniRemoveContract;
}
/**
 * Return the MniRemoveImport property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniRemoveImport() {
	if (ivjMniRemoveImport == null) {
		try {
			ivjMniRemoveImport = new javax.swing.JMenuItem();
			ivjMniRemoveImport.setName("MniRemoveImport");
			ivjMniRemoveImport.setText("L�schen");
			ivjMniRemoveImport.setEnabled(false);
			// user code begin {1}
			ivjMniRemoveImport.setText(getRemoveString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniRemoveImport;
}
/**
 * Return the MniRemoveTranslation property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getMniRemoveTranslation() {
	if (ivjMniRemoveTranslation == null) {
		try {
			ivjMniRemoveTranslation = new javax.swing.JMenuItem();
			ivjMniRemoveTranslation.setName("MniRemoveTranslation");
			ivjMniRemoveTranslation.setText("L�schen");
			ivjMniRemoveTranslation.setEnabled(false);
			// user code begin {1}
			ivjMniRemoveTranslation.setText(getRemoveString());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMniRemoveTranslation;
}
/**
 * Return the JPopupMenu1 property value.
 * @return javax.swing.JPopupMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPopupMenu getMnuContract() {
	if (ivjMnuContract == null) {
		try {
			ivjMnuContract = new javax.swing.JPopupMenu();
			ivjMnuContract.setName("MnuContract");
			ivjMnuContract.add(getMniOpenContractSpecification());
			ivjMnuContract.add(getJSeparator1());
			ivjMnuContract.add(getMniNewContract());
			ivjMnuContract.add(getMniRemoveContract());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMnuContract;
}
/**
 * Return the MnuImport property value.
 * @return javax.swing.JPopupMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPopupMenu getMnuImport() {
	if (ivjMnuImport == null) {
		try {
			ivjMnuImport = new javax.swing.JPopupMenu();
			ivjMnuImport.setName("MnuImport");
			ivjMnuImport.add(getMniOpenImportSpecification());
			ivjMnuImport.add(getJSeparator11());
			ivjMnuImport.add(getMniNewImport());
			ivjMnuImport.add(getMniRemoveImport());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMnuImport;
}
/**
 * Return the MnuTranslation property value.
 * @return javax.swing.JPopupMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPopupMenu getMnuTranslation() {
	if (ivjMnuTranslation == null) {
		try {
			ivjMnuTranslation = new javax.swing.JPopupMenu();
			ivjMnuTranslation.setName("MnuTranslation");
			ivjMnuTranslation.add(getMniOpenTranslationSpecification());
			ivjMnuTranslation.add(getJSeparator12());
			ivjMnuTranslation.add(getMniNewTranslation());
			ivjMnuTranslation.add(getMniRemoveTranslation());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMnuTranslation;
}
/**
 * Return the JPanel2 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPnlContract() {
	if (ivjPnlContract == null) {
		try {
			ivjPnlContract = new javax.swing.JPanel();
			ivjPnlContract.setName("PnlContract");
			ivjPnlContract.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsScpContract = new java.awt.GridBagConstraints();
			constraintsScpContract.gridx = 1; constraintsScpContract.gridy = 1;
			constraintsScpContract.fill = java.awt.GridBagConstraints.BOTH;
			constraintsScpContract.weightx = 1.0;
			constraintsScpContract.weighty = 1.0;
			constraintsScpContract.ipadx = 364;
			constraintsScpContract.ipady = 74;
			constraintsScpContract.insets = new java.awt.Insets(6, 5, 8, 5);
			getPnlContract().add(getScpContract(), constraintsScpContract);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlContract;
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

			java.awt.GridBagConstraints constraintsLblLanguage = new java.awt.GridBagConstraints();
			constraintsLblLanguage.gridx = 1; constraintsLblLanguage.gridy = 1;
			constraintsLblLanguage.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsLblLanguage.ipadx = 41;
			constraintsLblLanguage.insets = new java.awt.Insets(17, 11, 11, 3);
			getPnlDetail().add(getLblLanguage(), constraintsLblLanguage);

			java.awt.GridBagConstraints constraintsCbxLanguage = new java.awt.GridBagConstraints();
			constraintsCbxLanguage.gridx = 2; constraintsCbxLanguage.gridy = 1;
			constraintsCbxLanguage.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsCbxLanguage.weightx = 1.0;
			constraintsCbxLanguage.ipadx = 83;
			constraintsCbxLanguage.insets = new java.awt.Insets(14, 3, 5, 38);
			getPnlDetail().add(getCbxLanguage(), constraintsCbxLanguage);

			java.awt.GridBagConstraints constraintsLblTranslation = new java.awt.GridBagConstraints();
			constraintsLblTranslation.gridx = 1; constraintsLblTranslation.gridy = 2;
			constraintsLblTranslation.anchor = java.awt.GridBagConstraints.NORTHWEST;
			constraintsLblTranslation.ipadx = 65;
			constraintsLblTranslation.insets = new java.awt.Insets(6, 11, 2, 3);
			getPnlDetail().add(getLblTranslation(), constraintsLblTranslation);

			java.awt.GridBagConstraints constraintsScpTranslation = new java.awt.GridBagConstraints();
			constraintsScpTranslation.gridx = 1; constraintsScpTranslation.gridy = 3;
			constraintsScpTranslation.gridwidth = 2;
			constraintsScpTranslation.fill = java.awt.GridBagConstraints.BOTH;
			constraintsScpTranslation.weightx = 1.0;
			constraintsScpTranslation.weighty = 1.0;
			constraintsScpTranslation.ipadx = 355;
			constraintsScpTranslation.ipady = 110;
			constraintsScpTranslation.insets = new java.awt.Insets(2, 11, 6, 8);
			getPnlDetail().add(getScpTranslation(), constraintsScpTranslation);
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
 * Return the JPanel3 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPnlImport() {
	if (ivjPnlImport == null) {
		try {
			ivjPnlImport = new javax.swing.JPanel();
			ivjPnlImport.setName("PnlImport");
			ivjPnlImport.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsScpDependency = new java.awt.GridBagConstraints();
			constraintsScpDependency.gridx = 1; constraintsScpDependency.gridy = 1;
			constraintsScpDependency.fill = java.awt.GridBagConstraints.BOTH;
			constraintsScpDependency.weightx = 1.0;
			constraintsScpDependency.weighty = 1.0;
			constraintsScpDependency.ipadx = 355;
			constraintsScpDependency.ipady = 48;
			constraintsScpDependency.insets = new java.awt.Insets(10, 12, 10, 7);
			getPnlImport().add(getScpDependency(), constraintsScpDependency);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPnlImport;
}
/**
 * Return the JScrollPane1 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getScpContract() {
	if (ivjScpContract == null) {
		try {
			ivjScpContract = new javax.swing.JScrollPane();
			ivjScpContract.setName("ScpContract");
			ivjScpContract.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			ivjScpContract.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			getScpContract().setViewportView(getTblContract());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScpContract;
}
/**
 * Return the JScrollPane3 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getScpDependency() {
	if (ivjScpDependency == null) {
		try {
			ivjScpDependency = new javax.swing.JScrollPane();
			ivjScpDependency.setName("ScpDependency");
			ivjScpDependency.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			ivjScpDependency.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			getScpDependency().setViewportView(getTblImport());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScpDependency;
}
/**
 * Return the JScrollPane1 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getScpTranslation() {
	if (ivjScpTranslation == null) {
		try {
			ivjScpTranslation = new javax.swing.JScrollPane();
			ivjScpTranslation.setName("ScpTranslation");
			ivjScpTranslation.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			ivjScpTranslation.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			getScpTranslation().setViewportView(getTblTranslation());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScpTranslation;
}
/**
 * Return the TbcBaseLanguage property value.
 * @return javax.swing.table.TableColumn
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.table.TableColumn getTbcBaseLanguage() {
	if (ivjTbcBaseLanguage == null) {
		try {
			ivjTbcBaseLanguage = new javax.swing.table.TableColumn();
			ivjTbcBaseLanguage.setHeaderValue("BaseLanguage");
			// user code begin {1}
			ivjTbcBaseLanguage.setHeaderValue(resModelDefDialog.getString("TbcBaseLanguage_header"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcBaseLanguage;
}
/**
 * Return the TableColumn1 property value.
 * @return javax.swing.table.TableColumn
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.table.TableColumn getTbcIssuer() {
	if (ivjTbcIssuer == null) {
		try {
			ivjTbcIssuer = new javax.swing.table.TableColumn();
			ivjTbcIssuer.setHeaderValue("Issuer");
			// user code begin {1}
			ivjTbcIssuer.setHeaderValue(resModelDefDialog.getString("TbcIssuer_header"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcIssuer;
}
/**
 * Return the TbcLanguage property value.
 * @return javax.swing.table.TableColumn
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.table.TableColumn getTbcLanguage() {
	if (ivjTbcLanguage == null) {
		try {
			ivjTbcLanguage = new javax.swing.table.TableColumn();
			ivjTbcLanguage.setHeaderValue("Language");
			// user code begin {1}
			ivjTbcLanguage.setHeaderValue(resModelDefDialog.getString("TbcLanguage_header"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcLanguage;
}
/**
 * Return the TableColumn3 property value.
 * @return javax.swing.table.TableColumn
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.table.TableColumn getTbcModelDefName() {
	if (ivjTbcModelDefName == null) {
		try {
			ivjTbcModelDefName = new javax.swing.table.TableColumn();
			ivjTbcModelDefName.setHeaderValue("ModelDef");
			// user code begin {1}
			ivjTbcModelDefName.setHeaderValue(resModelDefDialog.getString("TbcModelDefName_header"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbcModelDefName;
}
/**
 * Return the TblContract property value.
 * @return javax.swing.JTable
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTable getTblContract() {
	if (ivjTblContract == null) {
		try {
			ivjTblContract = new javax.swing.JTable();
			ivjTblContract.setName("TblContract");
			getScpContract().setColumnHeaderView(ivjTblContract.getTableHeader());
			getScpContract().getViewport().setBackingStoreEnabled(true);
			ivjTblContract.setBounds(0, 0, 200, 200);
			ivjTblContract.addColumn(getTbcIssuer());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTblContract;
}
/**
 * Return the ScrollPaneTable2 property value.
 * @return javax.swing.JTable
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTable getTblImport() {
	if (ivjTblImport == null) {
		try {
			ivjTblImport = new javax.swing.JTable();
			ivjTblImport.setName("TblImport");
			getScpDependency().setColumnHeaderView(ivjTblImport.getTableHeader());
			getScpDependency().getViewport().setBackingStoreEnabled(true);
			ivjTblImport.setBounds(0, 0, 200, 200);
			ivjTblImport.setAutoCreateColumnsFromModel(false);
			ivjTblImport.addColumn(getTbcModelDefName());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTblImport;
}
/**
 * Return the ScrollPaneTable property value.
 * @return javax.swing.JTable
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTable getTblTranslation() {
	if (ivjTblTranslation == null) {
		try {
			ivjTblTranslation = new javax.swing.JTable();
			ivjTblTranslation.setName("TblTranslation");
			getScpTranslation().setColumnHeaderView(ivjTblTranslation.getTableHeader());
			getScpTranslation().getViewport().setBackingStoreEnabled(true);
			ivjTblTranslation.setBounds(0, 0, 200, 200);
			ivjTblTranslation.addColumn(getTbcLanguage());
			ivjTblTranslation.addColumn(getTbcBaseLanguage());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTblTranslation;
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
			ivjTbpGeneral.insertTab(resModelDefDialog.getString("TbpContract_title"), null, getPnlContract(), null, 2);
			ivjTbpGeneral.insertTab(resModelDefDialog.getString("TbpImport_title"), null, getPnlImport(), null, 3);
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
	getScpContract().addMouseListener(ivjEventHandler);
	getTblContract().addMouseListener(ivjEventHandler);
	getMniRemoveContract().addActionListener(ivjEventHandler);
	getMniNewContract().addActionListener(ivjEventHandler);
	getMniOpenContractSpecification().addActionListener(ivjEventHandler);
	getMniOpenImportSpecification().addActionListener(ivjEventHandler);
	getScpDependency().addMouseListener(ivjEventHandler);
	getTblImport().addMouseListener(ivjEventHandler);
	getMniRemoveImport().addActionListener(ivjEventHandler);
	getMniNewImport().addActionListener(ivjEventHandler);
	getScpTranslation().addMouseListener(ivjEventHandler);
	getTblTranslation().addMouseListener(ivjEventHandler);
	getMniOpenTranslationSpecification().addActionListener(ivjEventHandler);
	getMniNewTranslation().addActionListener(ivjEventHandler);
	getMniRemoveTranslation().addActionListener(ivjEventHandler);
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
		setName("ModelDefSpecificationDialog");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(426, 347);
		setTitle(resModelDefDialog.getString("ModelDefSpecificationDialog_title"));
		setContentPane(getBaseDialogContentPane());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// Type
	Vector types = new Vector();
	// @see #setElement() for correct sequence
	// @see #save()
	types.add(resModelDefDialog.getString("CITypeUnrestricted"));
	types.add(resModelDefDialog.getString("CITypeTYPE"));
	types.add(resModelDefDialog.getString("CITypeREFSYSTEM"));
	types.add(resModelDefDialog.getString("CITypeSYMBOLOGY"));
	getCbxType().setModel(new javax.swing.DefaultComboBoxModel(types));
	getCbxType().setSelectedIndex(-1);
	// user code end
}
/**
 * Add a new Item to Table.
 */
private void mniNewContract() {
	try {
		// update model
		Contract contract = ElementFactory.createContract(modelDef);
		// update view
		((EditorTableModel)getTblContract().getModel()).addRowElement(contract);
	} catch(Throwable e) {
		handleException(e);
	}
}
/**
 * Add new Import's.
 */
private void mniNewImport() {
	ModelElementSelectionDialog dialog = new ModelElementSelectionDialog(this, resModelDefDialog.getString("CTImportSelection"), true, modelDef); //$NON-NLS-1$
	getTblImport().setModel(new EditorTableModel());
	((EditorTableModel)getTblImport().getModel()).setClientDependency(modelDef.iteratorClientDependency(), resModelDefDialog.getString("TbcModelDefName_header"));//$NON-NLS-1$
}
/**
 * Comment
 */
private void mniNewTranslation() {
	try {
		// update model
		Translation translation = ElementFactory.createTranslation(modelDef);
		// update view
		((EditorTableModel)getTblTranslation().getModel()).addRowElement(translation);
	} catch(Throwable e) {
		handleException(e);
	}
}
/**
 * Comment
 */
private void mniOpenContractSpecification() {
	((EditorTableModel)getTblContract().getModel()).showSpecification(getTblContract().getSelectedRows());
}
/**
 * Comment
 */
private void mniOpenImportSpecification() {
	((EditorTableModel)getTblImport().getModel()).showDependencySpecification(getTblImport().getSelectedRows());
}
/**
 * Comment
 */
private void mniOpenTranslationSpecification() {
	((EditorTableModel)getTblTranslation().getModel()).showSpecification(getTblTranslation().getSelectedRows());
}
/**
 * Remove selected items from List.
 */
private void mniRemoveContract() {
	((EditorTableModel)getTblContract().getModel()).removeRows(getTblContract().getSelectedRows());
}
/**
 * Comment
 */
private void mniRemoveImport() {
	((EditorTableModel)getTblImport().getModel()).removeRows(getTblImport().getSelectedRows());
}
/**
 * Comment
 */
private void mniRemoveTranslation() {
	((EditorTableModel)getTblTranslation().getModel()).removeRows(getTblTranslation().getSelectedRows());
}
/**
 * Save ModelElement changes.
 * @see #okPressed()
 * @see #applyPressed()
 * @see #setTranslation()
 */
protected boolean save() {
	// general & page Description
	if (!ElementUtils.trySetName(modelDef, getTxtName().getText())) {
		return false;
	}
	getPnlDescription().getObject();
	// @see #initalize() for correct sequence
	// @see #setElement()
	switch (getCbxType().getSelectedIndex()) {
		case 0: {
			modelDef.setKind(ModelDefKind.DATA);
			break;
		}
		case 1: {
			modelDef.setKind(ModelDefKind.TYPE);
			break;
		}
		case 2: {
			modelDef.setKind(ModelDefKind.REFSYSTEM);
			break;
		}
		case 3: {
			modelDef.setKind(ModelDefKind.SYMBOLOGY);
			break;
		}
	}
	
	// page Detail
	modelDef.setBaseLanguage((String)getCbxLanguage().getSelectedItem());
		
	return super.save();
}
/**
 * Map model to view.
 */
private void setElement(ch.ehi.uml1_4.foundation.core.Element element) {
	modelDef = (ModelDef)element;

	// general & page Description
	getTxtName().setText(modelDef.getDefLangName());
	getPnlDescription().setObject(element);

	// @see #initalize() for correct sequence
	// @see #save()
	switch (modelDef.getKind()) {
		case ModelDefKind.DATA: {
			getCbxType().setSelectedIndex(0);
			break;
		}
		case ModelDefKind.TYPE: {
			getCbxType().setSelectedIndex(1);
			break;
		}
		case ModelDefKind.REFSYSTEM: {
			getCbxType().setSelectedIndex(2);
			break;
		}
		case ModelDefKind.SYMBOLOGY: {
			getCbxType().setSelectedIndex(3);
			break;
		}
		default: // illegal ModelDefKind
	}

	// page Detail
	Vector languages = new Vector();
	Set validLanguages = modelDef.getValidSecondLanguages();
	languages.add("");//$NON-NLS-1$
/*	languages.add("De_CH");
	languages.add("Fr_CH");
	languages.add("It_CH");
	languages.add("En_US");
*/
	Iterator iterator = validLanguages.iterator();
	while (iterator.hasNext()) {
		languages.add((String)iterator.next());
	}
	getCbxLanguage().setModel(new javax.swing.DefaultComboBoxModel(languages));
	getCbxLanguage().setSelectedItem(modelDef.getBaseLanguage());
	getTblTranslation().setModel(new EditorTableModel());
	((EditorTableModel)getTblTranslation().getModel()).setTranslation(modelDef.iteratorTranslation());
	
	// page Contract
	getTblContract().setModel(new EditorTableModel());
	((EditorTableModel)getTblContract().getModel()).setContract(modelDef.iteratorContract());

	// page Import
	getTblImport().setModel(new EditorTableModel());
	((EditorTableModel)getTblImport().getModel()).setClientDependency(modelDef.iteratorClientDependency(), ch.softenvironment.util.StringUtils.getPureClassName(ModelDef.class));
}
}