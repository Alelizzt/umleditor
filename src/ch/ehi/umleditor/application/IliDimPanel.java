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
import ch.softenvironment.view.*;
import ch.ehi.interlis.domainsandconstants.basetypes.*;
import javax.swing.*;
/**
 * User interface for a IliDim type.
 * 
 * @author: Peter Hirzel <i>soft</i>Environment 
 * @version $Revision: 1.1.1.1 $ $Date: 2003-12-23 10:39:10 $
 */
public class IliDimPanel extends DataPanel {
	private static java.util.ResourceBundle resIliDimPanel = java.util.ResourceBundle.getBundle("ch/ehi/umleditor/application/resources/IliDimPanel");
	private JComboBox ivjCbxAccuracy = null;
	private JTextField ivjTxtValue = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();

class IvjEventHandler implements java.awt.event.FocusListener {
		public void focusGained(java.awt.event.FocusEvent e) {
			if (e.getSource() == IliDimPanel.this.getTxtValue()) 
				connEtoM1(e);
		};
		public void focusLost(java.awt.event.FocusEvent e) {};
	};
/**
 * IliDimPanel constructor comment.
 */
public IliDimPanel() {
	super();
	initialize();
}
/**
 * connEtoM1:  (TxtValue.focus.focusGained(java.awt.event.FocusEvent) --> TxtValue.selectAll()V)
 * @param arg1 java.awt.event.FocusEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1(java.awt.event.FocusEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		getTxtValue().selectAll();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the CbxAccuracy property value.
 * @return javax.swing.JComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JComboBox getCbxAccuracy() {
	if (ivjCbxAccuracy == null) {
		try {
			ivjCbxAccuracy = new javax.swing.JComboBox();
			ivjCbxAccuracy.setName("CbxAccuracy");
			ivjCbxAccuracy.setToolTipText("");
			ivjCbxAccuracy.setBounds(113, 0, 47, 23);
			// user code begin {1}
			ivjCbxAccuracy.setToolTipText(resIliDimPanel.getString("CbxAccuracy_toolTipText"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCbxAccuracy;
}
/**
 * Return the changed object displayed.
 */
public Object getObject() {
	if ((getTxtValue().getText() == null) || (getTxtValue().getText().length() == 0)) {
		return null;
	} else {
		IliDim iliDim = IliDim.parseIliDim(getTxtValue().getText());
		if (getCbxAccuracy().getSelectedIndex() > 0) {
			iliDim.setAccuracy(((Long)getCbxAccuracy().getSelectedItem()).longValue());
		} else {
			// assume 0
			iliDim.setAccuracy(0);
		}
		return iliDim;
	}
}
/**
 * Return the TxtValue property value.
 * @return javax.swing.JTextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getTxtValue() {
	if (ivjTxtValue == null) {
		try {
			ivjTxtValue = new javax.swing.JTextField();
			ivjTxtValue.setName("TxtValue");
			ivjTxtValue.setToolTipText("");
			ivjTxtValue.setAlignmentY(java.awt.Component.TOP_ALIGNMENT);
			ivjTxtValue.setBounds(0, 1, 109, 20);
			ivjTxtValue.setEditable(true);
			ivjTxtValue.setEnabled(true);
			// user code begin {1}
			ivjTxtValue.setToolTipText(resIliDimPanel.getString("TxtValue_toolTipText"));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTxtValue;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
protected void handleException(java.lang.Throwable exception) {
	new ErrorDialog(this, resIliDimPanel.getString("CTError"), exception.toString(), exception); //$NON-NLS-1$
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getTxtValue().addFocusListener(ivjEventHandler);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("IliDimPanel");
		setLayout(null);
		setSize(161, 24);
		add(getTxtValue(), getTxtValue().getName());
		add(getCbxAccuracy(), getCbxAccuracy().getName());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	java.util.Vector accuracy = new java.util.Vector(6);
	for (int i=0; i<6; i++) {
		accuracy.add(new Long(i));
	}
	getCbxAccuracy().setModel(new DefaultComboBoxModel(accuracy));
	setObject(null);
	// user code end
}
/**
 * Set the Object to be displayed by panel.
 */
public void setObject(Object object) {
	IliDim iliDim = (IliDim)object;
	if (iliDim == null) {
		getTxtValue().setText(null);
		getCbxAccuracy().setSelectedIndex(0);
	} else {
		getTxtValue().setText(iliDim.toString());
		getCbxAccuracy().setSelectedItem(new Long(iliDim.getAccuracy()));
	}
}
}