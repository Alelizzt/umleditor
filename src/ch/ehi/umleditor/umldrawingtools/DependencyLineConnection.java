package ch.ehi.umleditor.umldrawingtools;

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
import ch.ehi.umleditor.umlpresentation.*;
import ch.ehi.uml1_4.implementation.*;
import ch.ehi.interlis.modeltopicclass.*;
import ch.ehi.uml1_4.foundation.core.*;
import java.awt.Graphics;
import CH.ifa.draw.figures.ArrowTip;
import CH.ifa.draw.framework.Figure;
import ch.ehi.umleditor.application.*;
import ch.softenvironment.view.*;
import ch.softenvironment.util.*;

/**
 * Draw a dependency line between two Figures representing dependable ModelElement's.
 * A dependency relation is a
 * uses-a relation with a direction where the connection points to the class
 * used by another one. The start class (Client) is dependend on the end class (Supplier).
 * A DependencyLineConnection has an arrow at the end point and is dotted.
 * 
 * @author: Peter Hirzel <i>soft</i>Environment 
 * @version $Revision: 1.1.1.1 $ $Date: 2003-12-23 10:40:53 $
 */
public class DependencyLineConnection extends EdgeFigure {
	private static java.util.ResourceBundle resDependencyLineConnection = java.util.ResourceBundle.getBundle("ch/ehi/umleditor/umldrawingtools/resources/DependencyLineConnection");  //$NON-NLS-1$

/**
 * Used to create new Dependency in ClassDiagram by UML-Tool.
 */
public DependencyLineConnection() {
    super();
}
/**
 * Used at reopening of ClassDiagram's containing Dependencies.
 * @see ClassDiagramView.setDiagramElement(Element)
 */
public DependencyLineConnection(ClassDiagramView classDiagram, PresentationEdge edge) {
    super(classDiagram);
    setLineColor(determineForegroundColor(edge)); // must precede edge-setting
    this.edge = edge;
    setModelElement((ModelElement)edge.iteratorSubject().next());
}
/**
 * Used to display a given Model-Dependency in given ClassDiagram.
 */
public DependencyLineConnection(ClassDiagramView classDiagram, Figure start, Figure end, ch.ehi.uml1_4.foundation.core.Dependency dependency) {
    super(classDiagram);
    setEdge(new ch.ehi.umleditor.umlpresentation.Dependency(), start, end);
	addModelElement((ModelElement)dependency);
}
protected void addSelectInBrowserMenu(javax.swing.JPopupMenu popupMenu) {}
/**
 * Add individual PopupMenu items for this class.
 * @see NodeFigure
 * @see createPopupMenu()
 */
protected void addSpecialMenu(javax.swing.JPopupMenu popupMenu) {}
protected void addSpecificationMenu(javax.swing.JPopupMenu popupMenu) {}
/**
 * Tests whether the two figures may be connected.
 * Overwrites.
 *
 * @param start figure representing the start/client class which is dependend on the end class
 * @param end   figure representing the end/supplier class
 */
public boolean canConnect(Figure start, Figure end) {
	GeneralizableElement client = null;
	GeneralizableElement supplier = null;

	try {
		// only GeneralizableElement's are valid types
		client = getGeneralizableElement(start);
		supplier = getGeneralizableElement(end);
	} catch(ClassCastException e) {
		shouldWarn(this, resDependencyLineConnection.getString("CWWrongDependencyType")); //$NON-NLS-1$
		return false;
	}

	if (!(((client instanceof Classifier) && (supplier instanceof Classifier)) ||
//			((client instanceof TopicDef) && (supplier instanceof TopicDef)) ||
			((client instanceof ch.ehi.uml1_4.modelmanagement.Package) && (supplier instanceof ch.ehi.uml1_4.modelmanagement.Package)))) {
		shouldWarn(this, resDependencyLineConnection.getString("CWNodesMustBeClassifier")); //$NON-NLS-1$
		return false;
	}

	return true;
}
/**
 * Draw the line which is a dotted line for a dependency connection. Instead
 * of drawing one line from start point to end point, the line is divided into
 * several small lines each 5 pixels long and 5 pixels away from the previous
 * line. Some minor inaccuracy are possible due to rounding errors or incomplete
 * last lines.
 *
 * @param g  graphics context into which the line is drawn
 * @param x1 start x point
 * @param y1 start y point
 * @param x2 end x point
 * @param y2 end y point
 */
protected void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
    int xDistance = x2 - x1;
    int yDistance = y2 - y1;
    double direction = Math.PI / 2 - Math.atan2(xDistance, yDistance);

    double xAngle = Math.cos(direction);
    double yAngle = Math.sin(direction);
    int lineLength = (int) Math.sqrt(xDistance * xDistance + yDistance * yDistance);

    for (int i = 0; i + 5 < lineLength; i = i + 10) {
        int p1x = x1 + (int) (i * xAngle);
        int p1y = y1 + (int) (i * yAngle);
        int p2x = x1 + (int) ((i + 5) * xAngle);
        int p2y = y1 + (int) ((i + 5) * yAngle);
        g.drawLine(p1x, p1y, p2x, p2y);
    }
}
/**
 * Return the ending/supplier ModelElement of the Relationship
 * @return Element
 */
protected Element getEndElement() {
	if (getModelElement() == null) {
		return null;
	} else {
Tracer.getInstance().nyi(this, "getSupplier()", "only first Dependency-Supplier is treated");//$NON-NLS-2$//$NON-NLS-1$
  	  return (Element)((ch.ehi.uml1_4.foundation.core.Dependency)getModelElement()).iteratorSupplier().next();
	}
}
/**
 * Return the starting/client by means dependent ModelElement of the Relationship.
 * @return Element
 */
protected Element getStartElement() {
	if (getModelElement() == null) {
		return null;
	} else {
Tracer.getInstance().nyi(this, "getClient()", "only first Dependency-Client is treated");//$NON-NLS-2$//$NON-NLS-1$
	    return (Element)((ch.ehi.uml1_4.foundation.core.Dependency)getModelElement()).iteratorClient().next();
	}
}
/**
 * Hook method to plug in application behaviour into
 * a template method. This method is called when a
 * connection between two objects has been established.
 *
 * @param start figure representing the start/client class which is dependend on the end class
 * @param end   figure representing the end/supplier class
 * @see canConnect(..)
 * @see removeInModel()
 */
protected void handleConnect(Figure start, Figure end) {
	try {
		if (getEdge() == null) {
			setEdge(new ch.ehi.umleditor.umlpresentation.Dependency(), start, end);

			GeneralizableElement client = getGeneralizableElement(start);
			GeneralizableElement supplier = getGeneralizableElement(end);
			ch.ehi.uml1_4.foundation.core.Dependency dependency = null;
			if ((client instanceof ModelDef) && (supplier instanceof ModelDef)) {
				dependency = ElementFactory.createDependency(IliImport.class, client, supplier);
			} else if ((client instanceof TopicDef) && (supplier instanceof TopicDef)) {
				dependency = ElementFactory.createDependency(TopicDepends.class, client, supplier);
			} else {
				// case ordinary Packages
				dependency = ElementFactory.createDependency(UmlUsage.class, client, supplier);
			}

			// sequence important!!!
		    setToolView();

			addModelElement((ModelElement)dependency);
		} // else dragging of existing Dependency was done
	} catch(Throwable e) {
		new ErrorDialog(LauncherView.getInstance(), CREATION_ERROR, resDependencyLineConnection.getString("CEDependencyNotEstablished"), e); //$NON-NLS-1$
	}
}
/**
 * Decorate the RelationShip-Ends.
 * Overwrites.
 */
protected void showDecoration() {
    setStartDecoration(null);
    ArrowTip arrow = new ArrowTip(0.4, 12.0, 0.0);
    arrow.setBorderColor(getLineColor());
    setEndDecoration(arrow);
}
/**
 * Show Warning message because Relationship is illegal between current start and end Figure.
 * @see shouldWarn(EdgeFigure, String)
 */
protected void showIllegalRelationship(java.lang.String warning) {
	new WarningDialog(LauncherView.getInstance(),
					resDependencyLineConnection.getString("CTUnallowedDependency"), //$NON-NLS-1$
					warning);
}
/**
 * Show the Specification Dialog of the PresentationElement.
 * @author Peter Hirzel
 */
public void showSpecification() {
	LauncherView.getInstance().showSpecification(getModelElement());
}
/**
 * Overwrites.
 */
public void updateView() {
	if ((getModelElement() != null) && (!((ch.ehi.uml1_4.foundation.core.Dependency)getModelElement()).iteratorSupplier().hasNext())) {
		removeVisually();
	} else {
		super.updateView();
	}
}
}