package ch.ehi.umleditor.interlis.iliimport;

import ch.interlis.ili2c.metamodel.*;
import ch.interlis.ili2c.config.Configuration;
import ch.interlis.ili2c.generator.Interlis2Generator;
import java.util.Iterator;
import ch.ehi.basics.types.NlsString;
import ch.ehi.basics.i18n.MessageFormat;
import ch.ehi.umleditor.interlis.Logging;

public class TransferFromIli2cMetamodel
{
  private Logging log=null;
  public TransferFromIli2cMetamodel(Logging callout){
    log=callout;
  }
  private java.util.ArrayList namespaceStack=new java.util.ArrayList();
  private void addNamespace(ch.ehi.uml1_4.foundation.core.Namespace ns)
  {
    namespaceStack.add(0,ns);
  }
  private ch.ehi.uml1_4.foundation.core.Namespace getNamespace()
  {
    return (ch.ehi.uml1_4.foundation.core.Namespace)namespaceStack.get(0);
  }
  private void removeNamespace()
  {
    namespaceStack.remove(0);
  }

  private java.util.HashMap fileMap=new java.util.HashMap();
  private ch.ehi.interlis.modeltopicclass.INTERLIS2Def findINTERLIS2Def(String filename1)
  {
    String filename=getBasename(filename1);
    if(fileMap.containsKey(filename)){
      return (ch.ehi.interlis.modeltopicclass.INTERLIS2Def)fileMap.get(filename);
    }
    ch.ehi.interlis.modeltopicclass.INTERLIS2Def ili2Def=new ch.ehi.interlis.modeltopicclass.INTERLIS2Def();
    ili2Def.setName(new NlsString(filename));
    fileMap.put(filename,ili2Def);
    ili2modelset.addOwnedElement(ili2Def);
    return ili2Def;
  }

  private java.util.HashMap modelMap=new java.util.HashMap();
  private ch.ehi.interlis.modeltopicclass.ModelDef findModelDef(Model model)
  {
    if(modelMap.containsKey(model)){
      return (ch.ehi.interlis.modeltopicclass.ModelDef)modelMap.get(model);
    }
    ch.ehi.interlis.modeltopicclass.ModelDef modelDef=new ch.ehi.interlis.modeltopicclass.ModelDef();
    modelMap.put(model,modelDef);
    return modelDef;
  }
  private java.util.HashMap topicMap=new java.util.HashMap();
  private ch.ehi.interlis.modeltopicclass.TopicDef findTopicDef(Topic topic)
  {
    if(topicMap.containsKey(topic)){
      return (ch.ehi.interlis.modeltopicclass.TopicDef)topicMap.get(topic);
    }
    ch.ehi.interlis.modeltopicclass.TopicDef topicDef=new ch.ehi.interlis.modeltopicclass.TopicDef();
    topicMap.put(topic,topicDef);
    return topicDef;
  }

  private java.util.HashMap gfxParamMap=new java.util.HashMap();
  private ch.ehi.interlis.graphicdescriptions.GraphicParameterDef findGraphicParameterDef(GraphicParameterDef gfxParam)
  {
    if(gfxParamMap.containsKey(gfxParam)){
      return (ch.ehi.interlis.graphicdescriptions.GraphicParameterDef)gfxParamMap.get(gfxParam);
    }
    ch.ehi.interlis.graphicdescriptions.GraphicParameterDef gfxParamDef=new ch.ehi.interlis.graphicdescriptions.GraphicParameterDef();
    gfxParamMap.put(gfxParam,gfxParamDef);
    return gfxParamDef;
  }

  private java.util.HashMap viewableMap=new java.util.HashMap();
  private ch.ehi.uml1_4.foundation.core.Classifier findViewable(Viewable table)
  {
    if(viewableMap.containsKey(table)){
      return (ch.ehi.uml1_4.foundation.core.Classifier)viewableMap.get(table);
    }
    throw new IllegalStateException("this Viewbale not yet seen");
  }

  private ch.ehi.interlis.modeltopicclass.ClassDef findClassDef(Table table)
  {
    if(viewableMap.containsKey(table)){
      return (ch.ehi.interlis.modeltopicclass.ClassDef)viewableMap.get(table);
    }
    ch.ehi.interlis.modeltopicclass.ClassDef classDef=new ch.ehi.interlis.modeltopicclass.ClassDef();
    viewableMap.put(table,classDef);
    return classDef;
  }

  private ch.ehi.interlis.associations.AssociationDef findAssociationDef(AssociationDef assoc)
  {
    if(viewableMap.containsKey(assoc)){
      return (ch.ehi.interlis.associations.AssociationDef)viewableMap.get(assoc);
    }
    ch.ehi.interlis.associations.AssociationDef assocDef=new ch.ehi.interlis.associations.AssociationDef();
    viewableMap.put(assoc,assocDef);
    return assocDef;
  }

  private ch.ehi.interlis.views.ViewDef findViewDef(View view)
  {
    if(viewableMap.containsKey(view)){
      return (ch.ehi.interlis.views.ViewDef)viewableMap.get(view);
    }
    ch.ehi.interlis.views.ViewDef viewDef=new ch.ehi.interlis.views.ViewDef();
    viewableMap.put(view,viewDef);
    return viewDef;
  }

  private ch.ehi.interlis.views.ViewProjectionDef findViewProjectionDef(Projection proj)
  {
    if(viewableMap.containsKey(proj)){
      return (ch.ehi.interlis.views.ViewProjectionDef)viewableMap.get(proj);
    }
    ch.ehi.interlis.views.ViewProjectionDef projDef=new ch.ehi.interlis.views.ViewProjectionDef();
    viewableMap.put(proj,projDef);
    return projDef;
  }

  private java.util.HashMap domainMap=new java.util.HashMap();
  private ch.ehi.interlis.domainsandconstants.DomainDef findDomainDef(Domain domain)
  {
    if(domainMap.containsKey(domain)){
      return (ch.ehi.interlis.domainsandconstants.DomainDef)domainMap.get(domain);
    }
    ch.ehi.interlis.domainsandconstants.DomainDef domainDef=new ch.ehi.interlis.domainsandconstants.DomainDef();
    domainMap.put(domain,domainDef);
    return domainDef;
  }
  private java.util.HashMap lineFormTypeMap=new java.util.HashMap();
  private ch.ehi.interlis.domainsandconstants.linetypes.LineFormTypeDef findLineFormTypeDef(LineForm lineFormType)
  {
    if(lineFormTypeMap.containsKey(lineFormType)){
      return (ch.ehi.interlis.domainsandconstants.linetypes.LineFormTypeDef)lineFormTypeMap.get(lineFormType);
    }
    ch.ehi.interlis.domainsandconstants.linetypes.LineFormTypeDef lineFormTypeDef=new ch.ehi.interlis.domainsandconstants.linetypes.LineFormTypeDef();
    lineFormTypeMap.put(lineFormType,lineFormTypeDef);
    return lineFormTypeDef;
  }
  private java.util.HashMap unitMap=new java.util.HashMap();
  private ch.ehi.interlis.units.UnitDef findUnitDef(Unit unit)
  {
    if(unitMap.containsKey(unit)){
      return (ch.ehi.interlis.units.UnitDef)unitMap.get(unit);
    }
    ch.ehi.interlis.units.UnitDef unitDef=new ch.ehi.interlis.units.UnitDef();
    unitMap.put(unit,unitDef);
    return unitDef;
  }
  private java.util.HashMap functionMap=new java.util.HashMap();
  private ch.ehi.interlis.functions.FunctionDef findFunctionDef(Function f)
  {
    if(functionMap.containsKey(f)){
      return (ch.ehi.interlis.functions.FunctionDef)functionMap.get(f);
    }
    ch.ehi.interlis.functions.FunctionDef funcDef=new ch.ehi.interlis.functions.FunctionDef();
    functionMap.put(f,funcDef);
    return funcDef;
  }
  private java.util.HashMap gfxMap=new java.util.HashMap();
  private ch.ehi.interlis.graphicdescriptions.GraphicDef findGraphicDef(Graphic g)
  {
    if(gfxMap.containsKey(g)){
      return (ch.ehi.interlis.graphicdescriptions.GraphicDef)gfxMap.get(g);
    }
    ch.ehi.interlis.graphicdescriptions.GraphicDef gfxDef=new ch.ehi.interlis.graphicdescriptions.GraphicDef();
    gfxMap.put(g,gfxDef);
    return gfxDef;
  }


  private void visitTopicDef(Topic topic)
  {
    if (topic == null)
      return;

    ch.ehi.interlis.modeltopicclass.TopicDef topicdef=findTopicDef(topic);
    topicdef.setName(new NlsString(topic.getName()));

    topicdef.setAbstract(topic.isAbstract());
    topicdef.setPropFinal(topic.isFinal());
    if(topic.isViewTopic()){
      topicdef.setKind(ch.ehi.interlis.modeltopicclass.TopicDefKind.VIEW);
    }else{
      topicdef.setKind(ch.ehi.interlis.modeltopicclass.TopicDefKind.DATA);
    }

    Topic extending = (Topic) topic.getExtending();
    if (extending != null)
    {
      ch.ehi.interlis.modeltopicclass.TopicDef parent=findTopicDef(extending);
      ch.ehi.interlis.modeltopicclass.TopicExtends topicextends=new ch.ehi.interlis.modeltopicclass.TopicExtends();
      topicextends.attachParent(parent);
      topicextends.attachChild(topicdef);
    }

    if(topic.getOid()!=null){
      topicdef.attachOiddomain(findDomainDef(topic.getOid()));
    }

    Iterator it = topic.getDependentOn();
    while(it.hasNext())
    {
      Topic depends=(Topic) it.next();
      ch.ehi.interlis.modeltopicclass.TopicDef supplier=findTopicDef(depends);
      ch.ehi.interlis.modeltopicclass.TopicDepends topicdepends=new ch.ehi.interlis.modeltopicclass.TopicDepends();
      topicdepends.addSupplier(supplier);
      topicdepends.addClient(topicdef);
    }


    getNamespace().addOwnedElement(topicdef);
    addNamespace(topicdef);

    visitElements(topic);

    CreateDiagramUtility.classes(topicdef);
    removeNamespace();

  }



  private void visitClassDef(Table tdef)
  {
    ch.ehi.interlis.modeltopicclass.ClassDef classdef=findClassDef(tdef);
    classdef.setName(new NlsString(tdef.getName()));

    classdef.setAbstract(tdef.isAbstract());
    classdef.setPropFinal(tdef.isFinal());
    if (tdef.isIdentifiable()){
      classdef.setKind(ch.ehi.interlis.modeltopicclass.ClassDefKind.CLASS);
    }else{
      classdef.setKind(ch.ehi.interlis.modeltopicclass.ClassDefKind.STRUCTURE);
    }

    Table extending = (Table) tdef.getExtending();
    if (extending != null)
    {
      ch.ehi.interlis.modeltopicclass.ClassDef parent=findClassDef(extending);
      ch.ehi.interlis.modeltopicclass.ClassExtends classextends=new ch.ehi.interlis.modeltopicclass.ClassExtends();
      classextends.attachParent(parent);
      classextends.attachChild(classdef);
      classextends.setExtended(tdef.isExtended());
    }


    getNamespace().addOwnedElement(classdef);
    addNamespace(classdef);
    visitElements(tdef);
    removeNamespace();


  }

  private void visitAssociationDef(AssociationDef assoc)
  {
    ch.ehi.interlis.associations.AssociationDef assocdef=findAssociationDef(assoc);
    assocdef.setName(new NlsString(assoc.getName()));

    assocdef.setAbstract(assoc.isAbstract());
    assocdef.setPropFinal(assoc.isFinal());
    //classdef.setKind(ch.ehi.interlis.modeltopicclass.ClassDefKind.CLASS);

    AssociationDef extending = (AssociationDef) assoc.getExtending();
    if (extending != null)
    {
      ch.ehi.interlis.associations.AssociationDef parent=findAssociationDef(extending);
      ch.ehi.interlis.modeltopicclass.ClassExtends classextends=new ch.ehi.interlis.modeltopicclass.ClassExtends();
      classextends.attachParent(parent);
      classextends.attachChild(assocdef);
      classextends.setExtended(assoc.isExtended());
    }

    // TODO handle DERIVED FROM in AssociationDef
    //Viewable derived = (AssociationDef) assoc.getDerivedFrom();


    getNamespace().addOwnedElement(assocdef);
    addNamespace(assocdef);
    visitElements(assoc);
    removeNamespace();

  }


  private void visitView (View view)
  {
    ch.ehi.interlis.views.ViewDef viewdef=findViewDef(view);
    viewdef.setName(new NlsString(view.getName()));
    makeSyntax.printView(view);
    viewdef.setSyntax(new NlsString(getSyntax()));
    getNamespace().addOwnedElement(viewdef);
  }



  private void visitGraphic (Graphic graph)
  {
    ch.ehi.interlis.graphicdescriptions.GraphicDef gfxdef=findGraphicDef(graph);
    gfxdef.setName(new NlsString(graph.getName()));
    makeSyntax.printGraphic(graph);
    gfxdef.setSyntax(new NlsString(getSyntax()));
    getNamespace().addOwnedElement(gfxdef);
  }





  private void visitUnit (Unit u)
  {
    ch.ehi.interlis.units.UnitDef unitdef=findUnitDef(u);
    unitdef.setName(new NlsString(u.getName()));
    if (!u.getDocName().equals(u.getName())) {
      unitdef.setDescName(new NlsString(u.getDocName()));
    }

    makeSyntax.printUnit(u.getContainer(),u);
    unitdef.setSyntax(new NlsString(getSyntax()));
    getNamespace().addOwnedElement(unitdef);

  }


  private void visitParameter (Parameter par)
  {
    ch.ehi.interlis.metaobjects.ParameterDef paramdef=new ch.ehi.interlis.metaobjects.ParameterDef();
    paramdef.setName(new NlsString(par.getName()));
    makeSyntax.printParameter(par.getContainer(),par);
    paramdef.setSyntax(new NlsString(getSyntax()));
    ((ch.ehi.interlis.modeltopicclass.ClassDef)getNamespace()).addParameterDef(paramdef);
  }

  private void visitGraphicParameterDef (GraphicParameterDef par)
  {
    ch.ehi.interlis.graphicdescriptions.GraphicParameterDef pdef=findGraphicParameterDef(par);
    pdef.setName(new NlsString(par.getName()));

    makeSyntax.printGraphicParameterDef(par);
    pdef.setSyntax(new NlsString(getSyntax()));
    getNamespace().addOwnedElement(pdef);
  }
  private void visitMetaDataUseDef(MetaDataUseDef mu)
  {
    ch.ehi.interlis.metaobjects.MetaDataUseDef mdef=new ch.ehi.interlis.metaobjects.MetaDataUseDef();
    mdef.setName(new NlsString(mu.getName()));
    TransferDescription td=(TransferDescription)mu.getContainer(TransferDescription.class);
    DataContainer basket=td.getMetaDataContainer(mu.getScopedName(null));
    if(basket!=null){
      mdef.setBasketOid(basket.getBoid());
    }
    makeSyntax.printMetaDataUseDef(mu);
    mdef.setSyntax(new NlsString(getSyntax()));
    getNamespace().addOwnedElement(mdef);
  }
  private void visitConstraint(Constraint constr)
  {
    ch.ehi.interlis.constraints.ConstraintDef cdef=new ch.ehi.interlis.constraints.ConstraintDef();
    ch.ehi.interlis.constraints.ConstraintExpression expr=new ch.ehi.interlis.constraints.ConstraintExpression();
    makeSyntax.printConstraint(constr);
    expr.setSyntax(new NlsString(getSyntax()));
    cdef.setBody(expr);
    getNamespace().addConstraint(cdef);
  }


  private ch.ehi.uml1_4.foundation.datatypes.Multiplicity visitCardinality(Cardinality card)
  {
    ch.ehi.uml1_4.implementation.UmlMultiplicityRange mr=new ch.ehi.uml1_4.implementation.UmlMultiplicityRange();
    mr.setLower(card.getMinimum());
    mr.setUpper(card.getMaximum()!=Cardinality.UNBOUND ? card.getMaximum(): ch.ehi.uml1_4.implementation.UmlMultiplicityRange.UNBOUND);
    ch.ehi.uml1_4.implementation.UmlMultiplicity m= new ch.ehi.uml1_4.implementation.UmlMultiplicity();
    m.addRange(mr);

    return m;
  }
  private void visitAttribute(AttributeDef attrib)
  {
    //System.out.println(attrib.getName());
    Type btype=attrib.getDomain();
    if(btype instanceof CompositionType){
        // StructureAttribute
        CompositionType type=(CompositionType)btype;
        ch.ehi.interlis.associations.AssociationDef assoc=new ch.ehi.interlis.associations.AssociationDef();
        ch.ehi.interlis.modeltopicclass.ClassDef dest=findClassDef((Table)type.getComponentType());
        ch.ehi.uml1_4.foundation.core.Class thisclass=(ch.ehi.uml1_4.foundation.core.Class)getNamespace();
        assoc.setName(new NlsString(thisclass.getDefLangName()+dest.getDefLangName()));
        ch.ehi.interlis.associations.RoleDef destRole=new ch.ehi.interlis.associations.RoleDef();
        destRole.setName(new NlsString(attrib.getName()));
        destRole.attachParticipant(dest);
        destRole.setMultiplicity(visitCardinality(type.getCardinality()));
        destRole.setOrdering(type.isOrdered()?ch.ehi.uml1_4.foundation.datatypes.OrderingKind.ORDERED:ch.ehi.uml1_4.foundation.datatypes.OrderingKind.UNORDERED);
        assoc.addConnection(destRole);
        ch.ehi.interlis.associations.RoleDef srcRole=new ch.ehi.interlis.associations.RoleDef();
        srcRole.attachParticipant(thisclass);
        srcRole.setName(thisclass.getName());
        srcRole.setAggregation(ch.ehi.uml1_4.foundation.datatypes.AggregationKind.COMPOSITE);
        srcRole.setIliAttributeKind(ch.ehi.interlis.associations.AssociationAsIliAttrKind.STRUCTURE);
        assoc.addConnection(srcRole);
        java.util.Iterator rIt=type.iteratorRestrictedTo();
        while(rIt.hasNext()){
          destRole.addRestriction(findClassDef((Table)rIt.next()));
        }
        // TODO FunctionCall
        // TODO AttributeValueUsage
        thisclass.getNamespace().addOwnedElement(assoc);
        return;
    }else if(btype instanceof ReferenceType){
        // ReferenceAttribute
        ReferenceType type=(ReferenceType)btype;
        ch.ehi.interlis.associations.AssociationDef assoc=new ch.ehi.interlis.associations.AssociationDef();
        ch.ehi.interlis.modeltopicclass.ClassDef dest=findClassDef((Table)type.getReferred());
        ch.ehi.uml1_4.foundation.core.Class thisclass=(ch.ehi.uml1_4.foundation.core.Class)getNamespace();
        assoc.setName(new NlsString(dest.getDefLangName()+thisclass.getDefLangName()));
        ch.ehi.interlis.associations.RoleDef destRole=new ch.ehi.interlis.associations.RoleDef();
        destRole.setName(new NlsString(attrib.getName()));
        destRole.attachParticipant(dest);
        assoc.addConnection(destRole);
        ch.ehi.interlis.associations.RoleDef srcRole=new ch.ehi.interlis.associations.RoleDef();
        srcRole.attachParticipant(thisclass);
        srcRole.setName(thisclass.getName());
        srcRole.setIliAttributeKind(ch.ehi.interlis.associations.AssociationAsIliAttrKind.REFERENCE);
        assoc.addConnection(srcRole);
        java.util.Iterator rIt=type.iteratorRestrictedTo();
        while(rIt.hasNext()){
          destRole.addRestriction(findClassDef((Table)rIt.next()));
        }
        // TODO FunctionCall
        // TODO AttributeValueUsage
        thisclass.getNamespace().addOwnedElement(assoc);
        return;
    }

    ch.ehi.interlis.attributes.AttributeDef attrdef=new ch.ehi.interlis.attributes.AttributeDef();
    attrdef.setName(new NlsString(attrib.getName()));
    attrdef.setAbstract(attrib.isAbstract());
    attrdef.setPropFinal(attrib.isFinal());
    attrdef.setPropExtended(attrib.getExtending()!=null);

    // TODO FunctionCall
    // TODO AttributeValueUsage
    // TODO Constant

    ch.ehi.interlis.attributes.AttrType battrtype=null;

    if (attrib instanceof LocalAttribute){
        // DomainAttribute
        ch.ehi.interlis.attributes.DomainAttribute attrtype=new ch.ehi.interlis.attributes.DomainAttribute();
        battrtype=attrtype;
        // BOOLEAN, HALIGNMENT, VALIGNMENT, NAME, URI are represented as TypeAlias in ili2c
        // resolve them first
        if(btype instanceof TypeAlias){
          Type predefinedBaseType=btype.resolveAliases();
          if(predefinedBaseType==ilibase.BOOLEAN.getType()
              || predefinedBaseType==ilibase.HALIGNMENT.getType()
              || predefinedBaseType==ilibase.VALIGNMENT.getType()
              || predefinedBaseType==ilibase.NAME.getType()
              || predefinedBaseType==ilibase.URI.getType()
              ){
            btype=predefinedBaseType;
          }
        }
        if(btype instanceof TypeAlias){
          TypeAlias type=(TypeAlias)btype;
          attrtype.attachDomainDef(findDomainDef(type.getAliasing()));
        }else{
          if(btype!=null){
            attrtype.attachDirect(visitType(attrib.getContainer(),btype));
          }
        }
    }

    ch.ehi.uml1_4.implementation.UmlMultiplicityRange r=new ch.ehi.uml1_4.implementation.UmlMultiplicityRange();
    r.setLower( btype.isMandatory() ? 1 : 0);
    r.setUpper(1);
    ch.ehi.uml1_4.implementation.UmlMultiplicity m=new ch.ehi.uml1_4.implementation.UmlMultiplicity();
    m.addRange(r);
    attrdef.setMultiplicity(m);

    attrdef.attachAttrType(battrtype);
    ((ch.ehi.uml1_4.foundation.core.Classifier)getNamespace()).addFeature(attrdef);
  }

  private void visitRoleDef(RoleDef role)
  {

    ch.ehi.interlis.associations.RoleDef roledef=new ch.ehi.interlis.associations.RoleDef();
    roledef.setName(new NlsString(role.getName()));
    roledef.setAbstract(role.isAbstract());
    roledef.setPropFinal(role.isFinal());
    roledef.setPropExtended(role.getExtending()!=null);
    roledef.setOrdering(role.isOrdered()
      ? ch.ehi.uml1_4.foundation.datatypes.OrderingKind.ORDERED
      : ch.ehi.uml1_4.foundation.datatypes.OrderingKind.UNORDERED);
    switch(role.getKind()){
      case RoleDef.Kind.eASSOCIATE:
        roledef.setAggregation(ch.ehi.uml1_4.foundation.datatypes.AggregationKind.NONE);
        break;
      case RoleDef.Kind.eAGGREGATE:
        roledef.setAggregation(ch.ehi.uml1_4.foundation.datatypes.AggregationKind.AGGREGATE);
        break;
      case RoleDef.Kind.eCOMPOSITE:
        roledef.setAggregation(ch.ehi.uml1_4.foundation.datatypes.AggregationKind.COMPOSITE);
        break;
    }
    if(role.getCardinality()!=null){
      roledef.setMultiplicity(visitCardinality(role.getCardinality()));
    }
    roledef.attachParticipant(findViewable(role.getDestination()));
    // TODO handle derived from in RoleDef

    ((ch.ehi.uml1_4.foundation.core.Association)getNamespace()).addConnection(roledef);
  }

  private void updatePredefinedModel(ch.ehi.uml1_4.modelmanagement.Package root){
    // find mdef in umlmodel
    if(!ch.ehi.uml1_4.tools.NamespaceUtility.deepContainsOwnedElement(
        root,ch.ehi.interlis.modeltopicclass.ModelDef.class,ilibase.getName())){
        return;
    }
    //    ch.ehi.interlis.modeltopicclass.ModelDef,
    ch.ehi.interlis.modeltopicclass.INTERLIS2Def ili2Def=(ch.ehi.interlis.modeltopicclass.INTERLIS2Def)ch.ehi.uml1_4.tools.NamespaceUtility.deepGetOwnedElement(
        root,ch.ehi.interlis.modeltopicclass.INTERLIS2Def.class,getPredefinedName());
    fileMap.put(getPredefinedName(),ili2Def);

    ch.ehi.interlis.modeltopicclass.ModelDef modelDef=(ch.ehi.interlis.modeltopicclass.ModelDef)ch.ehi.uml1_4.tools.NamespaceUtility.deepGetOwnedElement(
        ili2Def,ch.ehi.interlis.modeltopicclass.ModelDef.class,ilibase.getName());
    modelMap.put(ilibase,modelDef);
    Iterator it = ilibase.iterator();
    while (it.hasNext()) {
      ch.interlis.ili2c.metamodel.Element elt = (ch.interlis.ili2c.metamodel.Element) it.next();
      if (elt instanceof Unit)
      {
        ch.ehi.interlis.units.UnitDef unitDef=(ch.ehi.interlis.units.UnitDef)ch.ehi.uml1_4.tools.NamespaceUtility.deepGetOwnedElement(
          modelDef,ch.ehi.interlis.units.UnitDef.class,elt.getName());
        unitMap.put(elt,unitDef);
      }
      else if (elt instanceof Function)
      {
        ch.ehi.interlis.functions.FunctionDef funcDef=(ch.ehi.interlis.functions.FunctionDef)ch.ehi.uml1_4.tools.NamespaceUtility.deepGetOwnedElement(
          modelDef,ch.ehi.interlis.functions.FunctionDef.class,elt.getName());
        functionMap.put(elt,funcDef);
      }
      else if (elt instanceof Domain)
      {
        ch.ehi.interlis.domainsandconstants.DomainDef domainDef=(ch.ehi.interlis.domainsandconstants.DomainDef)ch.ehi.uml1_4.tools.NamespaceUtility.deepGetOwnedElement(
          modelDef,ch.ehi.interlis.domainsandconstants.DomainDef.class,elt.getName());
        domainMap.put(elt,domainDef);
      }
      else if (elt instanceof Table)
      {
        if (!((Table) elt).isImplicit ())
        {
        ch.ehi.interlis.modeltopicclass.ClassDef classDef=(ch.ehi.interlis.modeltopicclass.ClassDef)ch.ehi.uml1_4.tools.NamespaceUtility.deepGetOwnedElement(
          modelDef,ch.ehi.interlis.modeltopicclass.ClassDef.class,elt.getName());
        viewableMap.put(elt,classDef);
        }
      }

    }

  }

  private String getPredefinedName(){
    return "<"+rsrc.getString("CTpredefinedModel")+">";
  }

  private void visitModel (Model mdef)
  {
    Iterator it;
    if(mdef==ilibase && modelMap.containsKey(mdef))return;
    ch.ehi.interlis.modeltopicclass.ModelDef model=findModelDef(mdef);

    // language
    if(mdef.getLanguage()!=null){
	model.setBaseLanguage(mdef.getLanguage());
    }

    model.setName(new NlsString(mdef.getName()));

    // kind
    if(mdef instanceof DataModel){
      model.setKind(ch.ehi.interlis.modeltopicclass.ModelDefKind.DATA);
    }else if(mdef instanceof TypeModel){
      model.setKind(ch.ehi.interlis.modeltopicclass.ModelDefKind.TYPE);
    }else if(mdef instanceof RefSystemModel){
      model.setKind(ch.ehi.interlis.modeltopicclass.ModelDefKind.REFSYSTEM);
    }else if(mdef instanceof SymbologyModel){
      model.setKind(ch.ehi.interlis.modeltopicclass.ModelDefKind.SYMBOLOGY);
    }


    // contracts
    Contract[] contractv=mdef.getContracts();
    for (int i=0;i<contractv.length;i++)
    {
      ch.ehi.interlis.modeltopicclass.Contract contract=new ch.ehi.interlis.modeltopicclass.Contract();
      contract.setIssuer(new NlsString(contractv[i].getIssuer()));
      String expl=contractv[i].getExplanation();
      if ((expl != null) && (expl.length() > 0))
      {
        contract.setDocumentation(new NlsString(expl));
      }
      model.addContract(contract);
    }


    // imports
    Importable[] imported = mdef.getImporting ();
    if (imported.length > 0)
    {
      for (int i = 0; i < imported.length; i++)
      {
        Model curImport = (Model) imported[i];
        ch.ehi.interlis.modeltopicclass.ModelDef supplier=findModelDef(curImport);
        ch.ehi.interlis.modeltopicclass.IliImport iliimport=new ch.ehi.interlis.modeltopicclass.IliImport();
        iliimport.addSupplier(supplier);
        iliimport.addClient(model);
      }
    }

    // translation
    // TODO translatiom

    ch.ehi.interlis.modeltopicclass.INTERLIS2Def ili2def=null;
    if(mdef==ilibase){
      ili2def=findINTERLIS2Def(getPredefinedName());
      ili2def.setVersion(2.2);
    }else{
      ili2def=findINTERLIS2Def(mdef.getFileName());
      ili2def.setVersion(2.2);
    }

    ili2def.addOwnedElement(model);
    addNamespace(model);
    visitElements (mdef);
    CreateDiagramUtility.topicOverview(model);
    removeNamespace();

  }

  private void visitDomainDef (Domain dd)
  {
    ch.ehi.interlis.domainsandconstants.DomainDef domaindef=findDomainDef(dd);
    domaindef.setName(new NlsString(dd.getName()));

    domaindef.setAbstract(dd.isAbstract());
    domaindef.setPropFinal(dd.isFinal());
    // TODO handle MANDATORY DomainDef
    //domaindef.setMandatory();

    Domain extending = dd.getExtending();
    if (extending != null)
    {
      ch.ehi.interlis.domainsandconstants.DomainDef parent=findDomainDef(extending);
      ch.ehi.interlis.domainsandconstants.DomainExtends domainextends=new ch.ehi.interlis.domainsandconstants.DomainExtends();
      domainextends.attachParent(parent);
      domainextends.attachChild(domaindef);
    }

        // BOOLEAN, HALIGNMENT, VALIGNMENT, NAME, URI are represented as TypeAlias in ili2c
        // resolve them first
        Type btype=dd.getType();
        if(btype instanceof TypeAlias){
          Type predefinedBaseType=btype.resolveAliases();
          if(predefinedBaseType==ilibase.BOOLEAN.getType()
              || predefinedBaseType==ilibase.HALIGNMENT.getType()
              || predefinedBaseType==ilibase.VALIGNMENT.getType()
              || predefinedBaseType==ilibase.NAME.getType()
              || predefinedBaseType==ilibase.URI.getType()
              ){
            btype=predefinedBaseType;
          }
        }
    ch.ehi.interlis.domainsandconstants.Type type=visitType(dd.getContainer(),btype);
    domaindef.attachType(type);
    getNamespace().addOwnedElement(domaindef);
  }

  private ch.ehi.interlis.domainsandconstants.Type visitType(Container scope,Type dd)
  {
    ch.ehi.interlis.domainsandconstants.Type ret=null;

    // BOOLEAN, HALIGNMENT, VALIGNMENT, NAME, URI are represented as TypeAlias in ili2c
    if(dd==ilibase.BOOLEAN.getType()){
      ret=new ch.ehi.interlis.domainsandconstants.basetypes.BooleanType();
    }else if(dd==ilibase.HALIGNMENT.getType()){
      ret=new ch.ehi.interlis.domainsandconstants.basetypes.HorizAlignment();
    }else if(dd==ilibase.VALIGNMENT.getType()){
      ret=new ch.ehi.interlis.domainsandconstants.basetypes.VertAlignment();
    }else if(dd==ilibase.NAME.getType()){
      ch.ehi.interlis.domainsandconstants.basetypes.Text text=new ch.ehi.interlis.domainsandconstants.basetypes.Text();
      ret=text;
      text.setKind(ch.ehi.interlis.domainsandconstants.basetypes.TextKind.NAME);
    }else if(dd==ilibase.URI.getType()){
      ch.ehi.interlis.domainsandconstants.basetypes.Text text=new ch.ehi.interlis.domainsandconstants.basetypes.Text();
      ret=text;
      text.setKind(ch.ehi.interlis.domainsandconstants.basetypes.TextKind.URI);
    }else if (dd instanceof NumericalType){
      return visitNumericalType (scope,(NumericalType) dd);
    }else if (dd instanceof TextType){
      int len = ((TextType) dd).getMaxLength();
      ch.ehi.interlis.domainsandconstants.basetypes.Text text=new ch.ehi.interlis.domainsandconstants.basetypes.Text();
      ret=text;
      if (len != -1) {
        text.setKind(ch.ehi.interlis.domainsandconstants.basetypes.TextKind.MAXLEN);
        text.setMaxLength(len);
      }else{
        text.setKind(ch.ehi.interlis.domainsandconstants.basetypes.TextKind.UNDEFINED);
      }
      // URI and NAME are represented as TypeAlias in ili2c

    }else if (dd instanceof EnumerationType){
      ch.ehi.interlis.domainsandconstants.basetypes.Enumeration enum;
      EnumerationType et = (EnumerationType) dd;
      enum=visitEnumeration(et.getEnumeration());
      ret=enum;
      if (et.isCircular()){
        enum.setKind(ch.ehi.interlis.domainsandconstants.basetypes.EnumKind.CIRCULAR);
      }else if (et.isOrdered()){
        enum.setKind(ch.ehi.interlis.domainsandconstants.basetypes.EnumKind.ORDERED);
      }else{
        enum.setKind(ch.ehi.interlis.domainsandconstants.basetypes.EnumKind.UNDEFINED);
      }
    }else if (dd instanceof CoordType)
    {
      ch.ehi.interlis.domainsandconstants.basetypes.CoordinateType coord=new ch.ehi.interlis.domainsandconstants.basetypes.CoordinateType();
      ret=coord;
      NumericalType[] nts = ((CoordType) dd).getDimensions();
      for (int i = 0; i < nts.length; i++)
      {
        coord.addDim(visitNumericalType(scope,nts[i]));
      }

      int nullAxis = ((CoordType) dd).getNullAxis();
      int piHalfAxis = ((CoordType) dd).getPiHalfAxis();
      if (nullAxis != 0)
      {
        ch.ehi.interlis.domainsandconstants.basetypes.RotationDef rot=new ch.ehi.interlis.domainsandconstants.basetypes.RotationDef();
        rot.setNullAxis(nullAxis);
        rot.setPihalfAxis(piHalfAxis);
        coord.attachRotationDef(rot);
      }
    }
    else if (dd instanceof LineType)
    {
      LineType lt = (LineType) dd;
      ch.ehi.interlis.domainsandconstants.linetypes.LineType line=null;
      if (lt instanceof PolylineType){
        line=new ch.ehi.interlis.domainsandconstants.linetypes.IliPolyline();
        ((ch.ehi.interlis.domainsandconstants.linetypes.IliPolyline)line).setDirected(((PolylineType) lt).isDirected());
      }else if (lt instanceof SurfaceType){
        line=new ch.ehi.interlis.domainsandconstants.linetypes.IndividualSurface();
      }else if (lt instanceof AreaType){
        line=new ch.ehi.interlis.domainsandconstants.linetypes.Tesselation();
      }
      ret=line;


      LineForm[] lineForms = lt.getLineForms ();
      PrecisionDecimal maxOverlap = lt.getMaxOverlap ();
      Domain controlPointDomain = lt.getControlPointDomain ();
      Table lineAttributeStructure = null;


      if (lt instanceof SurfaceOrAreaType){
        lineAttributeStructure = ((SurfaceOrAreaType) lt).getLineAttributeStructure ();
      }

      if (lineForms.length > 0)
      {
        ch.ehi.interlis.domainsandconstants.linetypes.LineForm lf=new ch.ehi.interlis.domainsandconstants.linetypes.LineForm();
        line.attachLineForm(lf);
        for (int i = 0; i < lineForms.length; i++)
        {
          if(lineForms[i]==ilibase.ARCS){
            lf.setArcs(true);
          }else if(lineForms[i]==ilibase.STRAIGHTS){
            lf.setStraights(true);
          }else{
            lf.addLineFormTypeDef(findLineFormTypeDef(lineForms[i]));
          }
        }
      }


      if (controlPointDomain != null)
      {
        line.attachControlpoints(findDomainDef(controlPointDomain));
      }


      if (maxOverlap != null)
      {
        ch.ehi.interlis.domainsandconstants.linetypes.IntersectionDef is=new ch.ehi.interlis.domainsandconstants.linetypes.IntersectionDef();
        is.setMaxi(visitIliDim(maxOverlap));
        line.attachIntersectionDef(is);
      }



      if (lineAttributeStructure != null)
      {
        ((ch.ehi.interlis.domainsandconstants.linetypes.SurfaceType)line).attachLinAttrDef(findClassDef(lineAttributeStructure));
      }
    }else if (dd instanceof OIDType){
      ch.ehi.interlis.domainsandconstants.basetypes.OidType oid=new ch.ehi.interlis.domainsandconstants.basetypes.OidType();
      ret=oid;
      if(dd instanceof AnyOIDType){
        oid.setKind(ch.ehi.interlis.domainsandconstants.basetypes.OidKind.ANY);
      }else if(dd instanceof TextOIDType){
        oid.setKind(ch.ehi.interlis.domainsandconstants.basetypes.OidKind.TEXT);
        oid.attachOiddomain((ch.ehi.interlis.domainsandconstants.basetypes.BaseType)visitType(scope,((OIDType)dd).getOIDType()));
      }else if(dd instanceof NumericOIDType){
        oid.setKind(ch.ehi.interlis.domainsandconstants.basetypes.OidKind.NUMERIC);
        oid.attachOiddomain((ch.ehi.interlis.domainsandconstants.basetypes.BaseType)visitType(scope,((OIDType)dd).getOIDType()));
      }
    }else if (dd instanceof ClassType){
      ch.ehi.interlis.domainsandconstants.basetypes.ClassType classtype=new ch.ehi.interlis.domainsandconstants.basetypes.ClassType();
      ret=classtype;
      ClassType ct = (ClassType) dd;
      if(ct.isStructure()){
        classtype.setKind(ch.ehi.interlis.modeltopicclass.ClassDefKind.STRUCTURE);
      }else{
        classtype.setKind(ch.ehi.interlis.modeltopicclass.ClassDefKind.CLASS);
      }
      Iterator ri=ct.iteratorRestrictedTo();
      while(ri.hasNext()){
        Table r=(Table)ri.next();
        classtype.addRestrictedTo(findClassDef(r));
      }
    }else{
      // handle unknown types in a generic way
      ch.ehi.interlis.domainsandconstants.UnknownType ukn=new ch.ehi.interlis.domainsandconstants.UnknownType();
      ret=ukn;
      makeSyntax.printType(scope,dd);
      ukn.setSyntax(new NlsString(getSyntax()));
    }
    return ret;
  }


  private ch.ehi.interlis.domainsandconstants.basetypes.NumericalType visitNumericalType(Container scope,NumericalType btype)
  {

    ch.ehi.interlis.domainsandconstants.basetypes.NumericalType ret=null;

    if (btype instanceof NumericType)
    {
      NumericType type = (NumericType) btype;
      PrecisionDecimal min = type.getMinimum();
      PrecisionDecimal max = type.getMaximum();
      ch.ehi.interlis.domainsandconstants.basetypes.NumericType umlType=new ch.ehi.interlis.domainsandconstants.basetypes.NumericType();
      ret=umlType;
      if (min == null){
        umlType.setRangeDefined(false);
      }else{
        umlType.setRangeDefined(true);
        umlType.setMinDec(visitIliDim(min));
        umlType.setMaxDec(visitIliDim(max));
      }
    }
    else if (btype instanceof StructuredUnitType)
    {
      ch.ehi.interlis.domainsandconstants.basetypes.StructuredUnitType umlType=new ch.ehi.interlis.domainsandconstants.basetypes.StructuredUnitType();
      ret=umlType;
      umlType.setMinStruc(visitStructDec(((StructuredUnitType) btype).getMinimum()));
      umlType.setMaxStruc(visitStructDec(((StructuredUnitType) btype).getMaximum()));
    }


    ret.setCircular(btype.isCircular());


    if (btype.getUnit() != null)
    {
      ret.attachUnitDef(findUnitDef(btype.getUnit()));
    }


    switch (btype.getRotation())
    {
    case NumericType.ROTATION_COUNTERCLOCKWISE:
      ret.setDirection(ch.ehi.interlis.domainsandconstants.basetypes.RotationKind.COUNTERCLOCKWISE);
      break;
    case NumericType.ROTATION_CLOCKWISE:
      ret.setDirection(ch.ehi.interlis.domainsandconstants.basetypes.RotationKind.CLOCKWISE);
      break;
    case NumericType.ROTATION_NONE:
      ret.setDirection(ch.ehi.interlis.domainsandconstants.basetypes.RotationKind.UNDEFINED);
      break;
    }

    // RefSys
    if (btype.getReferenceSystem() != null)
    {
      makeSyntax.printReferenceSysRef (scope, btype.getReferenceSystem ());
      ch.ehi.interlis.domainsandconstants.basetypes.RefSys refsys=new ch.ehi.interlis.domainsandconstants.basetypes.RefSys();
      refsys.setSyntax(new NlsString(getSyntax()));
      ret.attachRefSys(refsys);
    }

    return ret;
  }
  private ch.ehi.interlis.domainsandconstants.basetypes.StructDec visitStructDec(Constant.Structured val)
  {
    return ch.ehi.interlis.domainsandconstants.basetypes.StructDec.parseStructDec(val.toString());
  }
  private ch.ehi.interlis.domainsandconstants.basetypes.IliDim visitIliDim(PrecisionDecimal val)
  {
    ch.ehi.interlis.domainsandconstants.basetypes.IliDim ret=new ch.ehi.interlis.domainsandconstants.basetypes.IliDim();
    ret.setValue(val.doubleValue());
    ret.setBase10shift(val.getExponent());
    ret.setAccuracy(val.getAccuracy());
    return ret;
  }

  private ch.ehi.interlis.domainsandconstants.basetypes.Enumeration visitEnumeration (ch.interlis.ili2c.metamodel.Enumeration enumer)
  {
    ch.ehi.interlis.domainsandconstants.basetypes.Enumeration ret=new ch.ehi.interlis.domainsandconstants.basetypes.Enumeration();
    Iterator iter = enumer.getElements();
    while (iter.hasNext()) {
      ret.addEnumElement(visitEnumerationElement((ch.interlis.ili2c.metamodel.Enumeration.Element) iter.next()));
    }
    return ret;
  }


  private ch.ehi.interlis.domainsandconstants.basetypes.EnumElement visitEnumerationElement (ch.interlis.ili2c.metamodel.Enumeration.Element ee)
  {
    ch.ehi.interlis.domainsandconstants.basetypes.EnumElement ret=new ch.ehi.interlis.domainsandconstants.basetypes.EnumElement();
    ret.setName(new NlsString(ee.getName()));


    ch.interlis.ili2c.metamodel.Enumeration subEnum = ee.getSubEnumeration();
    if (subEnum != null)
    {
      ret.attachChild(visitEnumeration(subEnum));
    }
    return ret;
  }


  private void visitLineFormTypeDef (LineForm lf)
  {
    ch.ehi.interlis.domainsandconstants.linetypes.LineFormTypeDef lfdef=findLineFormTypeDef(lf);
    lfdef.setName(new NlsString(lf.getName()));
    Table struct=lf.getSegmentStructure();
    if(struct!=null){
      lfdef.attachStructure(findClassDef(struct));
    }
    getNamespace().addOwnedElement(lfdef);

  }



  private void visitFunctionDeclaration(Function f)
  {
    ch.ehi.interlis.functions.FunctionDef funcdef=findFunctionDef(f);
    funcdef.setName(new NlsString(f.getName()));
    makeSyntax.printFunctionDeclaration(f.getContainer(),f);
    funcdef.setSyntax(new NlsString(getSyntax()));
    getNamespace().addOwnedElement(funcdef);
  }

  private void visitElements (Container container)
  {
    Class lastClass = null;


    Iterator it = container.iterator();
    while (it.hasNext()) {
      ch.interlis.ili2c.metamodel.Element elt = (ch.interlis.ili2c.metamodel.Element) it.next();

      if (elt instanceof Model)
      {
        visitModel((Model) elt);
      }

      else if (elt instanceof MetaDataUseDef)
      {
        visitMetaDataUseDef((MetaDataUseDef) elt);
      }
      else if (elt instanceof Unit)
      {
        visitUnit((Unit) elt);
      }
      else if (elt instanceof Function)
      {
        visitFunctionDeclaration ((Function) elt);
      }
      else if (elt instanceof LineForm)
      {
        visitLineFormTypeDef ((LineForm) elt);
      }
      else if (elt instanceof Domain)
      {
        visitDomainDef ((Domain) elt);
      }
      else if (elt instanceof GraphicParameterDef)
      {
        visitGraphicParameterDef((GraphicParameterDef) elt);
      }
      else if (elt instanceof Topic)
      {
        visitTopicDef((Topic) elt);
      }

      else if (elt instanceof AssociationDef)
      {
        visitAssociationDef((AssociationDef) elt);
      }
      else if (elt instanceof Table)
      {
        /* Only explicit tables are printed out.
           Line attribute tables, for example,
           are not printed out.
        */
        if (!((Table) elt).isImplicit ())
        {
          visitClassDef((Table) elt);
        }
      }
      else if (elt instanceof View)
      {
        visitView((View) elt);
      }
      else if (elt instanceof Graphic)
      {
        visitGraphic ((Graphic) elt);
      }

      else if (elt instanceof AttributeDef)
      {
        visitAttribute ((AttributeDef) elt);
      }
      if (elt instanceof RoleDef)
      {
        visitRoleDef((RoleDef) elt);
      }
      else if (elt instanceof Parameter)
      {
        visitParameter ((Parameter) elt);
      }
      else if (elt instanceof Constraint)
      {
        visitConstraint((Constraint) elt);
      }
    }
  }

  private void visitMetaDataFiles(ch.ehi.uml1_4.modelmanagement.Model model,Configuration config)
  {
    Iterator it=config.iteratorFileEntry();
    while(it.hasNext()){
      ch.interlis.ili2c.config.FileEntry fileIli=(ch.interlis.ili2c.config.FileEntry)it.next();
      if(fileIli.getKind()==ch.interlis.ili2c.config.FileEntryKind.METADATAFILE){
        ch.ehi.interlis.metaobjects.MetaObjectFile fileUml=new ch.ehi.interlis.metaobjects.MetaObjectFile();
        fileUml.setName(new NlsString("",getBasename(fileIli.getFilename())));
        model.addOwnedElement(fileUml);
      }
    }
  }

  Interlis2Generator makeSyntax=null;
  java.io.StringWriter syntaxBuffer=null;
  private String getSyntax()
  {
    String syntax=syntaxBuffer.toString();
    syntaxBuffer.getBuffer().setLength(0);
    return syntax;
  }

  private PredefinedModel ilibase;
  private ch.ehi.uml1_4.modelmanagement.Package ili2modelset;
  private static int uniqueName=1;
  public void visitTransferDescription (ch.ehi.uml1_4.modelmanagement.Model umlModel,
    TransferDescription   td,String configFilename,Configuration config)
  {
    syntaxBuffer=new java.io.StringWriter();
    makeSyntax=Interlis2Generator.generateElements(syntaxBuffer,td);
    ilibase=td.INTERLIS;
    updatePredefinedModel(umlModel);
    ili2modelset=new ch.ehi.uml1_4.implementation.UmlPackage();
    if(configFilename!=null){
      ili2modelset.setName(new NlsString(getBasename(configFilename)));
    }else{
      ili2modelset.setName(new NlsString(rsrc.getString("CTunnamedModelsetName")+Integer.toString(uniqueName)));
      uniqueName+=1;
    }
    // add model contents
    visitElements(td);
    // conversion done; add model to editor
    umlModel.addOwnedElement(ili2modelset);
    // add metadata files
    visitMetaDataFiles(umlModel,config);
  }
  public void loadPredefinedIli2cModel(ch.ehi.uml1_4.modelmanagement.Package root)
  {
    TransferDescription td=new TransferDescription();
    syntaxBuffer=new java.io.StringWriter();
    makeSyntax=Interlis2Generator.generateElements(syntaxBuffer,td);
    ilibase=td.INTERLIS;
    ili2modelset=root;
    // add model contents
    visitElements(td);
  }


  private static String getBasename(String filename)
  {
    return new java.io.File(filename).getName();
  }
  static java.util.ResourceBundle rsrc = ch.ehi.basics.i18n.ResourceBundle.getBundle(TransferFromIli2cMetamodel.class);

  public String getFuncDesc(){
    return rsrc.getString("CIiliimport");
  }

  private void logError(String msg){
    log.log(getFuncDesc(),msg);
  }
}