package org.liveontologies.protege.explanation.proof.editing;

/*-
 * #%L
 * This file is part of the OWL API.
 * The contents of this file are subject to the LGPL License, Version 3.0.
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 The University of Manchester
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L% 
 */

import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.AND;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.ANNOTATIONS;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.ANNOTATION_PROPERTY;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.ANTI_SYMMETRIC;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.ASYMMETRIC;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.CHAIN_CONNECT;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.CHARACTERISTICS;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.CLASS;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.CLOSE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.CLOSEBRACE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.CLOSEBRACKET;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.COMMA;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DASH;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DATATYPE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DATA_PROPERTY;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DIFFERENT_FROM;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DIFFERENT_INDIVIDUALS;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DISJOINT_CLASSES;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DISJOINT_PROPERTIES;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DISJOINT_UNION_OF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DISJOINT_WITH;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.DOMAIN;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.EQUIVALENT_CLASSES;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.EQUIVALENT_PROPERTIES;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.EQUIVALENT_TO;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.EXACTLY;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.FACTS;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.FUNCTIONAL;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.HAS_KEY;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.IMPORT;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.INDIVIDUAL;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.INDIVIDUALS;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.INV;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.INVERSE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.INVERSE_FUNCTIONAL;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.INVERSE_OF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.IRREFLEXIVE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_DOUBLE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_FALSE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_FLOAT;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_INTEGER;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_LITERAL;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_LIT_DATATYPE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_LIT_LANG;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.LITERAL_TRUE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.MAX;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.MAX_EXCLUSIVE_FACET;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.MAX_INCLUSIVE_FACET;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.MIN;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.MIN_EXCLUSIVE_FACET;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.MIN_INCLUSIVE_FACET;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.NOT;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.OBJECT_PROPERTY;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.ONLY;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.ONLYSOME;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.ONTOLOGY;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.OPEN;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.OPENBRACE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.OPENBRACKET;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.OR;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.PREFIX;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.RANGE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.REFLEXIVE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.RULE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SAME_AS;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SAME_INDIVIDUAL;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SELF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SOME;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SUBCLASS_OF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SUB_PROPERTY_CHAIN;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SUB_PROPERTY_OF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SUPERCLASS_OF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SUPER_PROPERTY_OF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.SYMMETRIC;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.THAT;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.TRANSITIVE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.TYPE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.TYPES;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.VALUE;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.VALUE_PARTITION;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.parse;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax.values;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntaxTokenizer.EOF;
import static org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntaxTokenizer.eof;
import static org.semanticweb.owlapi.util.OWLAPIPreconditions.verifyNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.expression.OWLOntologyChecker;
import org.semanticweb.owlapi.formats.ManchesterSyntaxDocumentFormat;
import org.semanticweb.owlapi.io.XMLUtils;
import org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntax;
import org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntaxOntologyHeader;
import org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntaxTokenizer;
import org.semanticweb.owlapi.manchestersyntax.parser.ManchesterOWLSyntaxTokenizer.Token;
import org.semanticweb.owlapi.manchestersyntax.renderer.ManchesterOWLSyntaxRenderer;
import org.semanticweb.owlapi.manchestersyntax.renderer.ParserException;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyCharacteristicAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEntityVisitor;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyCharacteristicAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLBuiltInAtom;
import org.semanticweb.owlapi.model.SWRLDArgument;
import org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom;
import org.semanticweb.owlapi.model.SWRLIArgument;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLSameIndividualAtom;
import org.semanticweb.owlapi.model.SWRLVariable;
import org.semanticweb.owlapi.model.SetOntologyID;
import org.semanticweb.owlapi.util.CollectionFactory;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.util.NamespaceUtil;
import org.semanticweb.owlapi.util.OntologyAxiomPair;
import org.semanticweb.owlapi.util.RemappingIndividualProvider;
import org.semanticweb.owlapi.util.mansyntax.ManchesterOWLSyntaxParser;
import org.semanticweb.owlapi.vocab.DublinCoreVocabulary;
import org.semanticweb.owlapi.vocab.Namespaces;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.semanticweb.owlapi.vocab.SWRLBuiltInsVocabulary;
import org.semanticweb.owlapi.vocab.XSDVocabulary;

import com.google.common.base.Optional;

/**
 * A parser for the Manchester OWL Syntax. All properties must be defined before
 * they are used. For example, consider the restriction hasPart some Leg. The
 * parser must know in advance whether or not hasPart is an object property or a
 * data property so that Leg gets parsed correctly. In a tool, such as an
 * editor, it is expected that hasPart will already exists as either a data
 * property or an object property. If a complete ontology is being parsed, it is
 * expected that hasPart will have been defined at the top of the file before it
 * is used in any class expressions or property assertions (e.g. ObjectProperty:
 * hasPart)
 * 
 * Patched to parse the output of {@link ManchesterOWLSyntaxRenderer}: the
 * {@link ManchesterOWLSyntax} vocabulary for which rendering is different from
 * the keyword is now matched using
 * {@link #matches(ManchesterOWLSyntax, String)} instead of
 * {@link ManchesterOWLSyntax#matches(String)} or
 * {@link ManchesterOWLSyntax#matchesEitherForm(String)}
 * 
 * @author Matthew Horridge, The University Of Manchester, Bio-Health
 *         Informatics Group
 * 
 * @author Yevgeny Kazakov
 * @since 2.2.0
 */
public class ManchesterOWLSyntaxParserPatched
		implements ManchesterOWLSyntaxParser {

	// This parser was built by hand! After struggling with terrible
	// error messages produced by ANTLR (or JavaCC) I decides to construct
	// this parser by hand. The error messages that this parser generates
	// are specific to the Manchester OWL Syntax and are such that it should
	// be easy to use this parser in tools such as editors.
	@Nonnull
	private Supplier<OWLOntologyLoaderConfiguration> configProvider;
	@Nonnull
	private Optional<OWLOntologyLoaderConfiguration> config = Optional.absent();
	protected OWLDataFactory dataFactory;
	private List<Token> tokens;
	private int tokenIndex;
	private OWLEntityChecker owlEntityChecker;
	private OWLOntologyChecker owlOntologyChecker = new OWLOntologyChecker() {

		@Nullable
		@Override
		public OWLOntology getOntology(String name) {
			return null;
		}
	};
	@Nonnull
	protected final Set<String> classNames = new HashSet<>();
	@Nonnull
	protected final Set<String> objectPropertyNames = new HashSet<>();
	@Nonnull
	protected final Set<String> dataPropertyNames = new HashSet<>();
	@Nonnull
	protected final Set<String> individualNames = new HashSet<>();
	@Nonnull
	protected final Set<String> dataTypeNames = new HashSet<>();
	@Nonnull
	protected final Set<String> annotationPropertyNames = new HashSet<>();
	@Nonnull
	private final Map<String, SWRLBuiltInsVocabulary> ruleBuiltIns = new HashMap<>();
	@Nonnull
	protected DefaultPrefixManager pm = new DefaultPrefixManager();
	@Nonnull
	protected final Set<ManchesterOWLSyntax> potentialKeywords = new HashSet<>();
	private OWLOntology defaultOntology;
	private final boolean allowEmptyFrameSections = false;
	private final Map<ManchesterOWLSyntax, AnnotatedListItemParser<OWLDataProperty, ?>> dataPropertyFrameSections = new EnumMap<>(
			ManchesterOWLSyntax.class);
	protected RemappingIndividualProvider anonProvider;

	/**
	 * @param configurationProvider
	 *            configuration provider
	 * @param dataFactory
	 *            dataFactory
	 */
	@Inject
	public ManchesterOWLSyntaxParserPatched(
			@Nonnull Supplier<OWLOntologyLoaderConfiguration> configurationProvider,
			@Nonnull OWLDataFactory dataFactory) {
		configProvider = configurationProvider;
		this.dataFactory = dataFactory;
		anonProvider = new RemappingIndividualProvider(this.dataFactory);
		pm.setPrefix("rdf:", Namespaces.RDF.toString());
		pm.setPrefix("rdfs:", Namespaces.RDFS.toString());
		pm.setPrefix("owl:", Namespaces.OWL.toString());
		pm.setPrefix("dc:", DublinCoreVocabulary.NAME_SPACE);
		NamespaceUtil u = new NamespaceUtil();
		initialiseClassFrameSections();
		initialiseObjectPropertyFrameSections();
		initialiseDataPropertyFrameSections();
		initialiseAnnotationPropertyFrameSections();
		initialiseIndividualFrameSections();
		for (XSDVocabulary v : XSDVocabulary.values()) {
			dataTypeNames.add(v.getIRI().toString());
			dataTypeNames.add(v.getIRI().toQuotedString());
			dataTypeNames.add(v.getPrefixedName());
		}
		dataTypeNames.add(OWLRDFVocabulary.RDFS_LITERAL.getPrefixedName());
		dataTypeNames.add(OWLRDFVocabulary.RDF_XML_LITERAL.getShortForm());
		dataTypeNames.add(OWLRDFVocabulary.RDF_XML_LITERAL.getPrefixedName());
		for (IRI iri : OWLRDFVocabulary.BUILT_IN_ANNOTATION_PROPERTY_IRIS) {
			String string = iri.toString();
			String ns = XMLUtils.getNCNamePrefix(string);
			String fragment = XMLUtils.getNCNameSuffix(string);
			annotationPropertyNames.add(
					u.getPrefix(ns) + ':' + (fragment != null ? fragment : ""));
		}
		owlEntityChecker = new DefaultEntityChecker();
		for (SWRLBuiltInsVocabulary v : SWRLBuiltInsVocabulary.values()) {
			ruleBuiltIns.put(v.getShortForm(), v);
			ruleBuiltIns.put(v.getIRI().toQuotedString(), v);
		}
	}

	@Override
	@Nonnull
	public OWLOntologyLoaderConfiguration getOntologyLoaderConfiguration() {
		if (config.isPresent()) {
			return config.get();
		}
		config = Optional.of(configProvider.get());
		return config.get();
	}

	@Override
	public void setOntologyLoaderConfigurationProvider(
			Supplier<OWLOntologyLoaderConfiguration> provider) {
		configProvider = provider;
	}

	@Override
	public void setOntologyLoaderConfiguration(
			OWLOntologyLoaderConfiguration config) {
		this.config = Optional.fromNullable(config);
	}

	@Override
	public void setStringToParse(String s) {
		tokens = new ArrayList<>();
		tokens.addAll(getTokenizer(s).tokenize());
		tokenIndex = 0;
	}

	protected static ManchesterOWLSyntaxTokenizer getTokenizer(String s) {
		return new ManchesterOWLSyntaxTokenizer(s);
	}

	private final Map<ManchesterOWLSyntax, AnnotatedListItemParser<OWLClass, ?>> classFrameSections = new EnumMap<>(
			ManchesterOWLSyntax.class);

	private void initialiseClassFrameSections() {
		initialiseSection(new EntityAnnotationsListItemParser<OWLClass>(),
				classFrameSections);
		initialiseSection(new ClassSubClassOfListItemParser(),
				classFrameSections);
		initialiseSection(new ClassEquivalentToListItemParser(),
				classFrameSections);
		initialiseSection(new ClassDisjointWithListItemParser(),
				classFrameSections);
		initialiseSection(new ClassHasKeyListItemParser(), classFrameSections);
		initialiseSection(new ClassDisjointUnionOfListItemParser(),
				classFrameSections);
		// Extensions
		initialiseSection(new ClassSuperClassOfListItemParser(),
				classFrameSections);
		initialiseSection(new ClassDisjointClassesListItemParser(),
				classFrameSections);
		initialiseSection(new ClassIndividualsListItemParser(),
				classFrameSections);
	}

	private final Map<ManchesterOWLSyntax, AnnotatedListItemParser<OWLObjectProperty, ?>> objectPropertyFrameSections = new EnumMap<>(
			ManchesterOWLSyntax.class);

	private void initialiseObjectPropertyFrameSections() {
		initialiseSection(
				new EntityAnnotationsListItemParser<OWLObjectProperty>(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertySubPropertyOfListItemParser(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertyEquivalentToListItemParser(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertyDisjointWithListItemParser(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertyDomainListItemParser(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertyRangeListItemParser(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertyInverseOfListItemParser(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertyCharacteristicsItemParser(),
				objectPropertyFrameSections);
		initialiseSection(new ObjectPropertySubPropertyChainListItemParser(),
				objectPropertyFrameSections);
		// Extensions
		initialiseSection(new ObjectPropertySuperPropertyOfListItemParser(),
				objectPropertyFrameSections);
	}

	private void initialiseDataPropertyFrameSections() {
		initialiseSection(new DataPropertySubPropertyOfListItemParser(),
				dataPropertyFrameSections);
		initialiseSection(new DataPropertyEquivalentToListItemParser(),
				dataPropertyFrameSections);
		initialiseSection(new DataPropertyDisjointWithListItemParser(),
				dataPropertyFrameSections);
		initialiseSection(new DataPropertyDomainListItemParser(),
				dataPropertyFrameSections);
		initialiseSection(new DataPropertyRangeListItemParser(),
				dataPropertyFrameSections);
		initialiseSection(new DataPropertyCharacteristicsItemParser(),
				dataPropertyFrameSections);
		initialiseSection(
				new EntityAnnotationsListItemParser<OWLDataProperty>(),
				dataPropertyFrameSections);
	}

	private final Map<ManchesterOWLSyntax, AnnotatedListItemParser<OWLAnnotationProperty, ?>> annotationPropertyFrameSections = new EnumMap<>(
			ManchesterOWLSyntax.class);

	private void initialiseAnnotationPropertyFrameSections() {
		initialiseSection(new AnnotationPropertySubPropertyOfListItemParser(),
				annotationPropertyFrameSections);
		initialiseSection(new AnnotationPropertyDomainListItemParser(),
				annotationPropertyFrameSections);
		initialiseSection(new AnnotationPropertyRangeListItemParser(),
				annotationPropertyFrameSections);
		initialiseSection(
				new EntityAnnotationsListItemParser<OWLAnnotationProperty>(),
				annotationPropertyFrameSections);
	}

	private final Map<ManchesterOWLSyntax, AnnotatedListItemParser<OWLIndividual, ?>> individualFrameSections = new EnumMap<>(
			ManchesterOWLSyntax.class);

	private void initialiseIndividualFrameSections() {
		initialiseSection(new IndividualAnnotationItemParser(),
				individualFrameSections);
		initialiseSection(new IndividualTypesItemParser(),
				individualFrameSections);
		initialiseSection(new IndividualFactsItemParser(),
				individualFrameSections);
		initialiseSection(new IndividualSameAsItemParser(),
				individualFrameSections);
		initialiseSection(new IndividualDifferentFromItemParser(),
				individualFrameSections);
		// Extensions
		initialiseSection(new IndividualDifferentIndividualsItemParser(),
				individualFrameSections);
	}

	@Override
	public void setOWLEntityChecker(OWLEntityChecker owlEntityChecker) {
		this.owlEntityChecker = owlEntityChecker;
	}

	private boolean isOntologyName(@Nonnull String name) {
		return owlOntologyChecker.getOntology(name) != null;
	}

	private boolean isClassName(@Nonnull String name) {
		return classNames.contains(name) || owlEntityChecker != null
				&& owlEntityChecker.getOWLClass(name) != null;
	}

	private OWLOntology getOntology(String name) {
		return owlOntologyChecker.getOntology(name);
	}

	@Override
	public void setOWLOntologyChecker(
			@Nonnull OWLOntologyChecker owlOntologyChecker) {
		this.owlOntologyChecker = owlOntologyChecker;
	}

	private boolean isObjectPropertyName(@Nonnull String name) {
		return objectPropertyNames.contains(name) || owlEntityChecker != null
				&& owlEntityChecker.getOWLObjectProperty(name) != null;
	}

	private boolean isAnnotationPropertyName(@Nonnull String name) {
		return annotationPropertyNames.contains(name)
				|| owlEntityChecker != null && owlEntityChecker
						.getOWLAnnotationProperty(name) != null;
	}

	private boolean isDataPropertyName(@Nonnull String name) {
		return dataPropertyNames.contains(name) || owlEntityChecker != null
				&& owlEntityChecker.getOWLDataProperty(name) != null;
	}

	private boolean isIndividualName(@Nonnull String name) {
		return individualNames.contains(name) || owlEntityChecker != null
				&& owlEntityChecker.getOWLIndividual(name) != null;
	}

	private boolean isDatatypeName(@Nonnull String name) {
		return dataTypeNames.contains(name) || owlEntityChecker != null
				&& owlEntityChecker.getOWLDatatype(name) != null;
	}

	private boolean isSWRLBuiltin(@Nonnull String name) {
		return ruleBuiltIns.containsKey(name);
	}

	@Nonnull
	private OWLClass getOWLClass(@Nonnull String name) {
		OWLClass cls = owlEntityChecker.getOWLClass(name);
		if (cls == null && classNames.contains(name)) {
			cls = dataFactory.getOWLClass(getIRI(name));
		}
		if (cls == null) {
			throw new ExceptionBuilder().withKeyword(potentialKeywords)
					.withClass().build();
		}
		return cls;
	}

	@Nonnull
	private OWLObjectProperty getOWLObjectProperty(@Nonnull String name) {
		OWLObjectProperty prop = owlEntityChecker.getOWLObjectProperty(name);
		if (prop == null && objectPropertyNames.contains(name)) {
			prop = dataFactory.getOWLObjectProperty(getIRI(name));
		}
		if (prop == null) {
			throw new ExceptionBuilder().withObject().build();
		}
		return prop;
	}

	@Nonnull
	private OWLIndividual getOWLIndividual(@Nonnull String name) {
		if (name.startsWith("_:")) {
			return anonProvider.getOWLAnonymousIndividual(name);
		}
		return getOWLNamedIndividual(name);
	}

	@Nonnull
	private OWLNamedIndividual getOWLNamedIndividual(@Nonnull String name) {
		OWLNamedIndividual ind = owlEntityChecker.getOWLIndividual(name);
		if (ind == null && individualNames.contains(name)) {
			ind = dataFactory.getOWLNamedIndividual(getIRI(name));
		}
		if (ind == null) {
			throw new ExceptionBuilder().withInd().build();
		}
		return ind;
	}

	@Nonnull
	private OWLDataProperty getOWLDataProperty(@Nonnull String name) {
		OWLDataProperty prop = owlEntityChecker.getOWLDataProperty(name);
		if (prop == null && dataPropertyNames.contains(name)) {
			prop = dataFactory.getOWLDataProperty(getIRI(name));
		}
		if (prop == null) {
			throw new ExceptionBuilder().withData().build();
		}
		return prop;
	}

	@Nonnull
	private OWLDatatype getOWLDatatype(@Nonnull String name) {
		OWLDatatype dt = owlEntityChecker.getOWLDatatype(name);
		if (dt == null && dataTypeNames.contains(name)) {
			dt = dataFactory.getOWLDatatype(getIRI(name));
		}
		if (dt == null) {
			throw new ExceptionBuilder().withDt().build();
		}
		return dt;
	}

	@Nonnull
	private OWLAnnotationProperty getOWLAnnotationProperty(
			@Nonnull String name) {
		OWLAnnotationProperty prop = owlEntityChecker
				.getOWLAnnotationProperty(name);
		if (prop == null && annotationPropertyNames.contains(name)) {
			prop = dataFactory.getOWLAnnotationProperty(getIRI(name));
		}
		if (prop == null) {
			throw new ExceptionBuilder().withAnn().build();
		}
		return prop;
	}

	protected Token getLastToken() {
		if (tokenIndex - 1 > -1) {
			return tokens.get(tokenIndex - 1);
		} else {
			return tokens.get(0);
		}
	}

	@Nonnull
	private String peekToken() {
		return getToken().getToken();
	}

	@Nonnull
	private String consumeToken() {
		String token = getToken().getToken();
		if (tokenIndex < tokens.size()) {
			tokenIndex++;
		}
		return token;
	}

	private void consumeToken(String expected) {
		String tok = consumeToken();
		if (!tok.equals(expected)) {
			throw new ExceptionBuilder().withKeyword(expected).build();
		}
	}

	private void consumeToken(ManchesterOWLSyntax expected) {
		String tok = consumeToken();
		if (!matches(expected, tok)) {
			throw new ExceptionBuilder().withKeyword(expected).build();
		}
	}

	private Token getToken() {
		return tokens
				.get(tokenIndex < tokens.size() ? tokenIndex : tokenIndex - 1);
	}

	public boolean matches(ManchesterOWLSyntax keyword, String string) {
		String rendering = keyword.toString();
		return rendering.equalsIgnoreCase(string)
				|| (rendering + ":").equalsIgnoreCase(string);
	}

	/* Parser */
	@Nonnull
	@Override
	public OWLClassExpression parseClassExpression() {
		OWLClassExpression desc = parseUnion();
		if (!eof(consumeToken())) {
			throw new ExceptionBuilder().withKeyword(EOF).build();
		}
		return desc;
	}

	@Override
	public OWLClassExpression parseClassExpression(String s) {
		setStringToParse(s);
		return parseClassExpression();
	}

	protected OWLClassExpression parseIntersection() {
		Set<OWLClassExpression> ops = new HashSet<>();
		String kw = AND.keyword();
		while (matches(AND, kw)) {
			potentialKeywords.remove(AND);
			ops.add(parseNonNaryClassExpression());
			potentialKeywords.add(AND);
			kw = peekToken();
			if (matches(AND, kw)) {
				kw = consumeToken();
			} else if (matches(THAT, kw)) {
				consumeToken();
				kw = AND.keyword();
			}
		}
		if (ops.size() == 1) {
			return ops.iterator().next();
		} else {
			return dataFactory.getOWLObjectIntersectionOf(ops);
		}
	}

	@Nonnull
	protected OWLClassExpression parseUnion() {
		Set<OWLClassExpression> ops = new HashSet<>();
		String kw = OR.keyword();
		while (matches(OR, kw)) {
			potentialKeywords.remove(OR);
			ops.add(parseIntersection());
			potentialKeywords.add(OR);
			kw = peekToken();
			if (matches(OR, kw)) {
				kw = consumeToken();
			}
		}
		if (ops.size() == 1) {
			return ops.iterator().next();
		} else {
			return dataFactory.getOWLObjectUnionOf(ops);
		}
	}

	@Nonnull
	protected OWLObjectPropertyExpression parseObjectPropertyExpression(
			boolean allowUndeclared) {
		String tok = consumeToken();
		if (matches(INVERSE, tok)) {
			String open = peekToken();
			boolean brackets = false;
			if (matches(OPEN, open)) {
				consumeToken();
				brackets = true;
			}
			OWLObjectPropertyExpression prop = parseObjectPropertyExpression(
					false);
			if (brackets) {
				String close = consumeToken();
				if (!matches(CLOSE, close)) {
					throw new ExceptionBuilder().withKeyword(CLOSE).build();
				}
			}
			return dataFactory.getOWLObjectInverseOf(prop);
		} else {
			if (!allowUndeclared && !isObjectPropertyName(tok)) {
				throw new ExceptionBuilder().withObject().build();
			}
			return getOWLObjectProperty(tok);
		}
	}

	private OWLPropertyExpression parsePropertyExpression() {
		String tok = peekToken();
		if (isObjectPropertyName(tok)) {
			return parseObjectPropertyExpression(false);
		} else if (matches(INVERSE, tok)) {
			return parseObjectPropertyExpression(false);
		} else if (isDataPropertyName(tok)) {
			return parseDataProperty();
		} else {
			consumeToken();
			throw new ExceptionBuilder().withObject().withData().build();
		}
	}

	/**
	 * Parses all class expressions except ObjectIntersectionOf and
	 * ObjectUnionOf.
	 * 
	 * @return The class expression which was parsed @ * if a non-nary class
	 *         expression could not be parsed
	 */
	private OWLClassExpression parseNonNaryClassExpression() {
		String tok = peekToken();
		if (matches(NOT, tok)) {
			consumeToken();
			OWLClassExpression complemented = parseNestedClassExpression(false);
			return dataFactory.getOWLObjectComplementOf(complemented);
		} else if (isObjectPropertyName(tok) || matches(INVERSE, tok)) {
			return parseObjectRestriction();
		} else if (isDataPropertyName(tok)) {
			// Data restriction
			return parseDataRestriction();
		} else if (matches(OPENBRACE, tok)) {
			return parseObjectOneOf();
		} else if (matches(OPEN, tok)) {
			return parseNestedClassExpression(false);
		} else if (isClassName(tok)) {
			consumeToken();
			return getOWLClass(tok);
		}
		// Add option for strict class name checking
		else {
			consumeToken();
			throw new ExceptionBuilder().withClass().withObject().withData()
					.withKeyword(OPEN, OPENBRACE, NOT, INVERSE).build();
		}
	}

	private OWLClassExpression parseObjectRestriction() {
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		String kw = consumeToken();
		if (matches(SOME, kw)) {
			String possSelfToken = peekToken();
			if (matches(SELF, possSelfToken)) {
				consumeToken();
				return dataFactory.getOWLObjectHasSelf(prop);
			} else {
				OWLClassExpression filler = null;
				try {
					filler = parseNestedClassExpression(false);
				} catch (ParserException e) {
					e.getExpectedKeywords().add(SELF.keyword());
					throw e;
				}
				return dataFactory.getOWLObjectSomeValuesFrom(prop, filler);
			}
		} else if (matches(ONLY, kw)) {
			OWLClassExpression filler = parseNestedClassExpression(false);
			return dataFactory.getOWLObjectAllValuesFrom(prop, filler);
		} else if (matches(VALUE, kw)) {
			String indName = consumeToken();
			if (!isIndividualName(indName)) {
				throw new ExceptionBuilder().withInd().build();
			}
			return dataFactory.getOWLObjectHasValue(prop,
					getOWLIndividual(indName));
		} else if (matches(MIN, kw)) {
			int card = parseInteger();
			OWLClassExpression filler = parseNestedClassExpression(true);
			return dataFactory.getOWLObjectMinCardinality(card, prop, filler);
		} else if (matches(MAX, kw)) {
			int card = parseInteger();
			OWLClassExpression filler = parseNestedClassExpression(true);
			return dataFactory.getOWLObjectMaxCardinality(card, prop, filler);
		} else if (matches(EXACTLY, kw)) {
			int card = parseInteger();
			OWLClassExpression filler = parseNestedClassExpression(true);
			return dataFactory.getOWLObjectExactCardinality(card, prop, filler);
		} else if (matches(ONLYSOME, kw)) {
			String tok = peekToken();
			Set<OWLClassExpression> descs = new HashSet<>();
			if (!matches(OPENBRACKET, tok)) {
				descs.add(parseUnion());
			} else {
				descs.addAll(
						parseClassExpressionList(OPENBRACKET, CLOSEBRACKET));
			}
			Set<OWLClassExpression> ops = new HashSet<>();
			for (OWLClassExpression desc : descs) {
				assert desc != null;
				ops.add(dataFactory.getOWLObjectSomeValuesFrom(prop, desc));
			}
			OWLClassExpression filler;
			if (descs.size() == 1) {
				filler = descs.iterator().next();
			} else {
				filler = dataFactory.getOWLObjectUnionOf(descs);
			}
			assert filler != null;
			ops.add(dataFactory.getOWLObjectAllValuesFrom(prop, filler));
			return dataFactory.getOWLObjectIntersectionOf(ops);
		} else if (matches(SELF, kw)) {
			return dataFactory.getOWLObjectHasSelf(prop);
		} else {
			// Error!
			throw new ExceptionBuilder()
					.withKeyword(SOME, ONLY, VALUE, MIN, MAX, EXACTLY, SELF)
					.build();
		}
	}

	private OWLClassExpression parseDataRestriction() {
		OWLDataPropertyExpression prop = parseDataProperty();
		String kw = consumeToken();
		if (matches(SOME, kw)) {
			OWLDataRange rng = parseDataRange();
			return dataFactory.getOWLDataSomeValuesFrom(prop, rng);
		} else if (matches(ONLY, kw)) {
			OWLDataRange rng = parseDataRange();
			return dataFactory.getOWLDataAllValuesFrom(prop, rng);
		} else if (matches(VALUE, kw)) {
			OWLLiteral con = parseLiteral(null);
			return dataFactory.getOWLDataHasValue(prop, con);
		} else if (matches(MIN, kw)) {
			int card = parseInteger();
			OWLDataRange rng = parseDataRange();
			return dataFactory.getOWLDataMinCardinality(card, prop, rng);
		} else if (matches(EXACTLY, kw)) {
			int card = parseInteger();
			OWLDataRange rng = parseDataRange();
			return dataFactory.getOWLDataExactCardinality(card, prop, rng);
		} else if (matches(MAX, kw)) {
			int card = parseInteger();
			OWLDataRange rng = parseDataRange();
			return dataFactory.getOWLDataMaxCardinality(card, prop, rng);
		}
		throw new ExceptionBuilder()
				.withKeyword(SOME, ONLY, VALUE, MIN, EXACTLY, MAX).build();
	}

	private OWLFacet parseFacet() {
		String facet = consumeToken();
		if (MIN_INCLUSIVE_FACET.matches(facet, peekToken())) {
			consumeToken();
			return OWLFacet.MIN_INCLUSIVE;
		}
		if (MAX_INCLUSIVE_FACET.matches(facet, peekToken())) {
			consumeToken();
			return OWLFacet.MAX_INCLUSIVE;
		}
		if (matches(MIN_EXCLUSIVE_FACET, facet)) {
			return OWLFacet.MIN_EXCLUSIVE;
		}
		if (matches(MAX_EXCLUSIVE_FACET, facet)) {
			return OWLFacet.MAX_EXCLUSIVE;
		}
		return OWLFacet.getFacetBySymbolicName(facet);
	}

	@Nonnull
	private OWLDatatype parseDatatype() {
		String name = consumeToken();
		return getOWLDatatype(name);
	}

	@Override
	public OWLDataRange parseDataRange() {
		return parseDataIntersectionOf();
	}

	@Nonnull
	private OWLDataRange parseDataIntersectionOf() {
		String sep = AND.keyword();
		Set<OWLDataRange> ranges = new HashSet<>();
		while (matches(AND, sep)) {
			ranges.add(parseDataUnionOf());
			sep = peekToken();
			if (matches(AND, sep)) {
				consumeToken();
			}
		}
		if (ranges.isEmpty()) {
			return dataFactory.getTopDatatype();
		}
		if (ranges.size() == 1) {
			return ranges.iterator().next();
		}
		return dataFactory.getOWLDataIntersectionOf(ranges);
	}

	private OWLDataRange parseDataUnionOf() {
		String sep = OR.keyword();
		Set<OWLDataRange> ranges = new HashSet<>();
		while (matches(OR, sep)) {
			ranges.add(parseDataRangePrimary());
			sep = peekToken();
			if (matches(OR, sep)) {
				consumeToken();
			}
		}
		if (ranges.size() == 1) {
			return ranges.iterator().next();
		} else {
			return dataFactory.getOWLDataUnionOf(ranges);
		}
	}

	@Nonnull
	private OWLDataRange parseDataRangePrimary() {
		String tok = peekToken();
		if (isDatatypeName(tok)) {
			consumeToken();
			OWLDatatype datatype = getOWLDatatype(tok);
			String next = peekToken();
			if (matches(OPENBRACKET, next)) {
				// Restricted data range
				consumeToken();
				String sep = COMMA.keyword();
				Set<OWLFacetRestriction> facetRestrictions = new HashSet<>();
				while (matches(COMMA, sep)) {
					OWLFacet fv = parseFacet();
					if (fv == null) {
						throw new ExceptionBuilder()
								.withKeyword(OWLFacet.getFacets()).build();
					}
					OWLLiteral con = parseLiteral(datatype);
					facetRestrictions
							.add(dataFactory.getOWLFacetRestriction(fv, con));
					sep = consumeToken();
				}
				if (!matches(CLOSEBRACKET, sep)) {
					throw new ExceptionBuilder().withKeyword(CLOSEBRACKET)
							.build();
				}
				return dataFactory.getOWLDatatypeRestriction(datatype,
						facetRestrictions);
			} else {
				return datatype;
			}
		} else if (matches(NOT, tok)) {
			return parseDataComplementOf();
		} else if (matches(OPENBRACE, tok)) {
			return parseDataOneOf();
		} else if (matches(OPEN, tok)) {
			consumeToken();
			OWLDataRange rng = parseDataRange();
			consumeToken(CLOSE.keyword());
			return rng;
		} else {
			consumeToken();
			throw new ExceptionBuilder().withDt().withKeyword(OPENBRACE, NOT)
					.build();
		}
	}

	@Override
	@Nonnull
	public Set<OWLDataRange> parseDataRangeList() {
		String sep = COMMA.keyword();
		Set<OWLDataRange> ranges = new HashSet<>();
		while (matches(COMMA, sep)) {
			potentialKeywords.remove(COMMA);
			OWLDataRange rng = parseDataRange();
			ranges.add(rng);
			potentialKeywords.add(COMMA);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return ranges;
	}

	@Nonnull
	private OWLDataRange parseDataOneOf() {
		consumeToken();
		Set<OWLLiteral> cons = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			OWLLiteral con = parseLiteral(null);
			cons.add(con);
			sep = consumeToken();
		}
		if (!matches(CLOSEBRACE, sep)) {
			throw new ExceptionBuilder().withKeyword(COMMA, CLOSEBRACE).build();
		}
		return dataFactory.getOWLDataOneOf(cons);
	}

	@Nonnull
	private OWLDataRange parseDataComplementOf() {
		String not = consumeToken();
		if (!matches(NOT, not)) {
			throw new ExceptionBuilder().withKeyword(NOT).build();
		}
		OWLDataRange complementedDataRange = parseDataRangePrimary();
		return dataFactory.getOWLDataComplementOf(complementedDataRange);
	}

	@Nonnull
	@Override
	public OWLLiteral parseLiteral(OWLDatatype datatype) {
		String tok = consumeToken();
		if (tok.startsWith("\"")) {
			@Nonnull
			String lit = unquoteLiteral(tok);
			if (peekToken().equals("^")) {
				consumeToken();
				if (!peekToken().equals("^")) {
					throw new ExceptionBuilder().withKeyword("^").build();
				}
				consumeToken();
				return dataFactory.getOWLLiteral(lit, parseDatatype());
			} else if (peekToken().startsWith("@")) {
				// Plain literal with a language tag
				String lang = consumeToken().substring(1);
				return dataFactory.getOWLLiteral(lit, lang);
			} else {
				// Plain literal without a language tag
				return dataFactory.getOWLLiteral(lit, "");
			}
		} else {
			if (datatype != null) {
				// datatype is known from context
				return dataFactory.getOWLLiteral(tok, datatype);
			}
			try {
				int i = Integer.parseInt(tok);
				return dataFactory.getOWLLiteral(i);
			} catch (@SuppressWarnings("unused") NumberFormatException e) {
				// Ignore - not interested
			}
			if (tok.endsWith("f") || tok.endsWith("F")) {
				try {
					// XXX this extra F might qualify as Float a Double INF/-INF
					float f = Float.parseFloat(tok.replace("INF", "Infinity")
							.replace("inf", "Infinity"));
					return dataFactory.getOWLLiteral(asFloat(f),
							OWL2Datatype.XSD_FLOAT);
				} catch (@SuppressWarnings("unused") NumberFormatException e) {
					// Ignore - not interested
				}
			}
			try {
				// ensure it's a valid double, or skip
				Double.parseDouble(tok);
				return dataFactory.getOWLLiteral(tok, OWL2Datatype.XSD_DECIMAL);
			} catch (@SuppressWarnings("unused") NumberFormatException e) {
				// Ignore - not interested
			}
			if (matches(LITERAL_TRUE, tok)) {
				return dataFactory.getOWLLiteral(true);
			} else if (matches(LITERAL_FALSE, tok)) {
				return dataFactory.getOWLLiteral(false);
			}
		}
		throw new ExceptionBuilder().withKeyword(LITERAL_TRUE, LITERAL_FALSE,
				LITERAL_INTEGER, LITERAL_FLOAT, LITERAL_DOUBLE, LITERAL_LITERAL,
				LITERAL_LIT_DATATYPE, LITERAL_LIT_LANG).build();
	}

	@Nonnull
	private String unquoteLiteral(String tok) {
		String lit = "";
		if (!tok.endsWith("\"")) {
			consumeToken();
			throw new ExceptionBuilder().withKeyword("\"").build();
		}
		if (tok.length() > 2) {
			lit = tok.substring(1, tok.length() - 1);
		}
		return verifyNotNull(lit);
	}

	@Nonnull
	private static String asFloat(float f) {
		return Float.toString(f).replace("Infinity", "INF");
	}

	private int parseInteger() {
		String i = consumeToken();
		try {
			return Integer.parseInt(i);
		} catch (@SuppressWarnings("unused") NumberFormatException e) {
			throw new ExceptionBuilder().withInt().build();
		}
	}

	@Nonnull
	private OWLClassExpression parseNestedClassExpression(
			boolean lookaheadCheck) {
		String tok = peekToken();
		if (matches(OPEN, tok)) {
			consumeToken();
			OWLClassExpression desc = parseUnion();
			String closeBracket = consumeToken();
			if (!matches(CLOSE, closeBracket)) {
				// Error!
				throw new ExceptionBuilder().withKeyword(CLOSE).build();
			}
			return desc;
		} else if (matches(OPENBRACE, tok)) {
			return parseObjectOneOf();
		} else if (isClassName(tok)) {
			String name = consumeToken();
			return getOWLClass(name);
		}
		// XXX problem: if the class expression is missing, we should return
		// owl:Thing. But there are many ways in which it could be missing. Hard
		// to tell what sort of lookahead is needed.
		// The next two checks should cover most cases.
		for (ManchesterOWLSyntax x : values()) {
			if (matches(x, tok)) {
				return dataFactory.getOWLThing();
			}
		}
		if (eof(tok)) {
			return dataFactory.getOWLThing();
		}
		if (!eof(tok) || !lookaheadCheck) {
			consumeToken();
			throw new ExceptionBuilder().withKeyword(OPEN, OPENBRACE)
					.withClass().build();
		}
		return dataFactory.getOWLThing();
	}

	@Nonnull
	private OWLClassExpression parseObjectOneOf() {
		String open = consumeToken();
		if (!matches(OPENBRACE, open)) {
			throw new ExceptionBuilder().withKeyword(OPENBRACE).build();
		}
		String sep = COMMA.keyword();
		Set<OWLIndividual> inds = new HashSet<>();
		while (matches(COMMA, sep)) {
			inds.add(parseIndividual());
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		String close = consumeToken();
		if (!matches(CLOSEBRACE, close)) {
			throw new ExceptionBuilder().withKeyword(CLOSEBRACE, COMMA).build();
		}
		return dataFactory.getOWLObjectOneOf(inds);
	}

	private static <F> void initialiseSection(
			AnnotatedListItemParser<F, ?> parser,
			Map<ManchesterOWLSyntax, AnnotatedListItemParser<F, ?>> map,
			ManchesterOWLSyntax... synonyms) {
		map.put(parser.getFrameSectionKeyword(), parser);
		for (ManchesterOWLSyntax syn : synonyms) {
			map.put(syn, parser);
		}
	}

	@Override
	@Nonnull
	public Set<OntologyAxiomPair> parseFrames() {
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		Set<ManchesterOWLSyntax> possible = new HashSet<>();
		resetPossible(possible);
		while (true) {
			String tok = peekToken();
			if (matches(CLASS, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				axioms.addAll(parseClassFrame());
				possible.addAll(classFrameSections.keySet());
			} else if (matches(OBJECT_PROPERTY, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				axioms.addAll(parseObjectPropertyFrame());
				possible.addAll(objectPropertyFrameSections.keySet());
			} else if (matches(DATA_PROPERTY, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				axioms.addAll(parseDataPropertyFrame());
				possible.addAll(dataPropertyFrameSections.keySet());
			} else if (matches(ANNOTATION_PROPERTY, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				axioms.addAll(parseAnnotationPropertyFrame());
				possible.addAll(Arrays.asList(SUB_PROPERTY_OF, DOMAIN, RANGE));
			} else if (matches(INDIVIDUAL, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				axioms.addAll(parseIndividualFrame());
				possible.addAll(
						Arrays.asList(TYPES, FACTS, DIFFERENT_FROM, SAME_AS));
			} else if (matches(DATATYPE, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				axioms.addAll(parseDatatypeFrame());
				possible.add(EQUIVALENT_TO);
			} else if (matches(VALUE_PARTITION, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				parseValuePartitionFrame();
			} else if (matches(RULE, tok)) {
				potentialKeywords.clear();
				resetPossible(possible);
				axioms.addAll(parseRuleFrame());
			} else {
				if (eof(tok)) {
					break;
				} else {
					consumeToken();
					throw new ExceptionBuilder().withKeyword(possible).build();
				}
			}
		}
		return axioms;
	}

	@Override
	public Set<OntologyAxiomPair> parseDatatypeFrame() {
		String tok = consumeToken();
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		if (!matches(DATATYPE, tok)) {
			throw new ExceptionBuilder().withKeyword(DATATYPE).build();
		}
		String subj = consumeToken();
		OWLDatatype datatype = getOWLDatatype(subj);
		axioms.add(new OntologyAxiomPair(defaultOntology,
				dataFactory.getOWLDeclarationAxiom(datatype)));
		while (true) {
			String sect = peekToken();
			if (matches(EQUIVALENT_TO, sect)) {
				potentialKeywords.clear();
				consumeToken();
				Set<OWLOntology> onts = getOntologies();
				Set<OWLDataRange> drs = parseDataRangeList();
				for (OWLOntology ont : onts) {
					assert ont != null;
					for (OWLDataRange dr : drs) {
						assert dr != null;
						axioms.add(new OntologyAxiomPair(ont, dataFactory
								.getOWLDatatypeDefinitionAxiom(datatype, dr)));
					}
				}
			} else if (matches(ANNOTATIONS, sect)) {
				potentialKeywords.clear();
				axioms.addAll(parseAnnotations(datatype.getIRI()));
			} else {
				break;
			}
		}
		return axioms;
	}

	private static void resetPossible(Set<ManchesterOWLSyntax> possible) {
		possible.clear();
		possible.add(ANNOTATIONS);
		possible.add(ANNOTATION_PROPERTY);
		possible.add(CLASS);
		possible.add(OBJECT_PROPERTY);
		possible.add(DATATYPE);
		possible.add(DATA_PROPERTY);
		possible.add(INDIVIDUAL);
		possible.add(VALUE_PARTITION);
		possible.add(RULE);
	}

	private Set<OntologyAxiomPair> parseNaryEquivalentClasses() {
		String tok = consumeToken();
		if (!matches(EQUIVALENT_CLASSES, tok)) {
			throw new ExceptionBuilder().withKeyword(EQUIVALENT_CLASSES)
					.build();
		}
		Set<OWLOntology> ontologies = getOntologies();
		Set<OWLAnnotation> annotations = parseAnnotations();
		Set<OWLClassExpression> classExpressions = parseClassExpressionList();
		Set<OntologyAxiomPair> pairs = new HashSet<>();
		for (OWLOntology ont : ontologies) {
			assert ont != null;
			pairs.add(new OntologyAxiomPair(ont,
					dataFactory.getOWLEquivalentClassesAxiom(classExpressions,
							annotations)));
		}
		return pairs;
	}

	private Set<OntologyAxiomPair> parseNaryEquivalentProperties() {
		String tok = consumeToken();
		if (!matches(EQUIVALENT_PROPERTIES, tok)) {
			throw new ExceptionBuilder().withKeyword(EQUIVALENT_PROPERTIES)
					.build();
		}
		Set<OWLOntology> ontologies = getOntologies();
		Set<OWLAnnotation> annotations = parseAnnotations();
		Set<OWLPropertyExpression> properties = parsePropertyList();
		OWLAxiom propertyAxiom;
		if (properties.iterator().next().isObjectPropertyExpression()) {
			Set<OWLObjectPropertyExpression> ope = new HashSet<>();
			for (OWLPropertyExpression pe : properties) {
				ope.add((OWLObjectPropertyExpression) pe);
			}
			propertyAxiom = dataFactory
					.getOWLEquivalentObjectPropertiesAxiom(ope, annotations);
		} else {
			Set<OWLDataPropertyExpression> dpe = new HashSet<>();
			for (OWLPropertyExpression pe : properties) {
				dpe.add((OWLDataPropertyExpression) pe);
			}
			propertyAxiom = dataFactory.getOWLEquivalentDataPropertiesAxiom(dpe,
					annotations);
		}
		Set<OntologyAxiomPair> pairs = new HashSet<>();
		for (OWLOntology ont : ontologies) {
			assert ont != null;
			pairs.add(new OntologyAxiomPair(ont, propertyAxiom));
		}
		return pairs;
	}

	@Nonnull
	private Set<OWLAnnotation> parseAnnotations() {
		String next = peekToken();
		@Nonnull
		Set<OWLAnnotation> annotations = CollectionFactory.emptySet();
		if (matches(ANNOTATIONS, next)) {
			consumeToken();
			annotations = parseAnnotationList();
		}
		return annotations;
	}

	private Set<OntologyAxiomPair> parseAnnotations(
			@Nonnull OWLAnnotationSubject s) {
		String header = consumeToken();
		if (!matches(ANNOTATIONS, header)) {
			throw new ExceptionBuilder().withKeyword(ANNOTATIONS).build();
		}
		Set<OWLOntology> onts = getOntologies();
		Set<OntologyAxiomPair> pairs = new HashSet<>();
		Set<OWLAnnotation> annos = parseAnnotationList();
		for (OWLOntology ont : onts) {
			assert ont != null;
			for (OWLAnnotation anno : annos) {
				assert anno != null;
				if (getOntologyLoaderConfiguration().isLoadAnnotationAxioms()) {
					pairs.add(new OntologyAxiomPair(ont, dataFactory
							.getOWLAnnotationAssertionAxiom(s, anno)));
				}
			}
		}
		return pairs;
	}

	@Nonnull
	private Set<OWLAnnotation> parseAnnotationList() {
		String sep = COMMA.keyword();
		Set<OWLAnnotation> annos = new HashSet<>();
		while (matches(COMMA, sep)) {
			potentialKeywords.clear();
			Set<OWLAnnotation> annotations = parseAnnotations();
			OWLAnnotation anno = parseAnnotation();
			anno = anno.getAnnotatedAnnotation(annotations);
			annos.add(anno);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return annos;
	}

	@Nonnull
	protected OWLAnnotation parseAnnotation() {
		OWLAnnotationProperty annoProp = parseAnnotationProperty();
		String obj = peekToken();
		OWLAnnotation anno = null;
		if (isIndividualName(obj) || isClassName(obj)
				|| isObjectPropertyName(obj) || isDataPropertyName(obj)) {
			consumeToken();
			OWLAnnotationValue value;
			if (obj.startsWith("_:")) {
				value = anonProvider.getOWLAnonymousIndividual(obj);
			} else {
				value = getIRI(obj);
			}
			anno = dataFactory.getOWLAnnotation(annoProp, value);
		} else if (obj.startsWith("<")) {
			IRI value = parseIRI();
			anno = dataFactory.getOWLAnnotation(annoProp, value);
		} else {
			OWLLiteral con = parseLiteral(null);
			anno = dataFactory.getOWLAnnotation(annoProp, con);
		}
		return anno;
	}

	@Override
	public Set<OntologyAxiomPair> parseClassFrame() {
		return parseClassFrame(false);
	}

	@Override
	public Set<OntologyAxiomPair> parseClassFrameEOF() {
		return parseClassFrame(true);
	}

	@Nonnull
	private Set<OntologyAxiomPair> parseClassFrame(boolean eof) {
		String tok = consumeToken();
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		if (!matches(CLASS, tok)) {
			throw new ExceptionBuilder().withKeyword(CLASS).build();
		}
		String subj = consumeToken();
		OWLClass cls = getOWLClass(subj);
		axioms.add(new OntologyAxiomPair(defaultOntology,
				dataFactory.getOWLDeclarationAxiom(cls)));
		parseFrameSections(eof, axioms, cls, classFrameSections);
		return axioms;
	}

	@Nonnull
	private Set<OWLOntology> parseOntologyList() {
		potentialKeywords.clear();
		consumeToken(OPENBRACKET.keyword());
		consumeToken("in");
		String sep = COMMA.keyword();
		Set<OWLOntology> onts = new HashSet<>();
		while (matches(COMMA, sep)) {
			String tok = consumeToken();
			if (isOntologyName(tok)) {
				OWLOntology ont = getOntology(tok);
				if (ont != null) {
					onts.add(ont);
				}
			} else {
				throw new ExceptionBuilder().withOnto().build();
			}
			sep = consumeToken();
			if (sep.equals(CLOSEBRACKET.keyword())) {
				break;
			} else if (!matches(COMMA, sep)) {
				throw new ExceptionBuilder().withKeyword(COMMA, CLOSEBRACKET)
						.build();
			}
		}
		return onts;
	}

	@Nonnull
	private Set<OWLOntology> getOntologies() {
		if (peekToken().equals(OPENBRACKET.keyword())) {
			return parseOntologyList();
		} else {
			return CollectionFactory.createSet(defaultOntology);
		}
	}

	@Override
	public void setDefaultOntology(@Nonnull OWLOntology defaultOntology) {
		this.defaultOntology = defaultOntology;
	}

	private boolean isEmptyFrameSection(Map<ManchesterOWLSyntax, ?> parsers) {
		if (!allowEmptyFrameSections) {
			return false;
		}
		String next = peekToken();
		return !matches(ANNOTATIONS, next)
				&& (parsers.containsKey(parse(next)) || eof(next));
	}

	private <F> void parseFrameSections(boolean eof,
			Set<OntologyAxiomPair> axioms, @Nonnull F frameSubject,
			Map<ManchesterOWLSyntax, AnnotatedListItemParser<F, ?>> sectionParsers) {
		while (true) {
			String sect = peekToken();
			AnnotatedListItemParser<F, ?> parser = sectionParsers
					.get(parse(sect));
			if (parser != null) {
				consumeToken();
				Set<OWLOntology> onts = getOntologies();
				if (!isEmptyFrameSection(sectionParsers)) {
					axioms.addAll(parseAnnotatedListItems(frameSubject, parser,
							onts));
				}
			} else if (eof && !eof(sect)) {
				List<ManchesterOWLSyntax> expected = new ArrayList<>();
				expected.addAll(sectionParsers.keySet());
				if (frameSubject instanceof OWLAnnotationSubject
						|| frameSubject instanceof OWLEntity) {
					expected.add(ANNOTATIONS);
				}
				throw new ExceptionBuilder().withKeyword(expected).build();
			} else {
				break;
			}
		}
	}

	@Override
	public Set<OntologyAxiomPair> parseObjectPropertyFrame() {
		return parseObjectPropertyFrame(false);
	}

	@Nonnull
	private Set<OntologyAxiomPair> parseObjectPropertyFrame(boolean eof) {
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		consumeToken(OBJECT_PROPERTY);
		String token = consumeToken();
		OWLObjectProperty prop = getOWLObjectProperty(token);
		if (!prop.isAnonymous()) {
			axioms.add(new OntologyAxiomPair(defaultOntology, dataFactory
					.getOWLDeclarationAxiom(prop.asOWLObjectProperty())));
		}
		parseFrameSections(eof, axioms, prop, objectPropertyFrameSections);
		return axioms;
	}

	@Override
	public Set<OntologyAxiomPair> parseDataPropertyFrame() {
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		String tok = consumeToken();
		if (!matches(DATA_PROPERTY, tok)) {
			throw new ExceptionBuilder().withKeyword(DATA_PROPERTY).build();
		}
		String subj = consumeToken();
		OWLDataProperty prop = getOWLDataProperty(subj);
		axioms.add(new OntologyAxiomPair(defaultOntology,
				dataFactory.getOWLDeclarationAxiom(prop)));
		parseFrameSections(false, axioms, prop, dataPropertyFrameSections);
		return axioms;
	}

	@Override
	public Set<OntologyAxiomPair> parseAnnotationPropertyFrame() {
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		String tok = consumeToken();
		if (!matches(ANNOTATION_PROPERTY, tok)) {
			throw new ExceptionBuilder().withKeyword(ANNOTATION_PROPERTY)
					.build();
		}
		String subj = consumeToken();
		OWLAnnotationProperty prop = getOWLAnnotationProperty(subj);
		for (OWLOntology ont : getOntologies()) {
			axioms.add(new OntologyAxiomPair(ont,
					dataFactory.getOWLDeclarationAxiom(prop)));
		}
		parseFrameSections(false, axioms, prop,
				annotationPropertyFrameSections);
		return axioms;
	}

	@Override
	public Set<OntologyAxiomPair> parseIndividualFrame() {
		String tok = consumeToken();
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		if (!matches(INDIVIDUAL, tok)) {
			throw new ExceptionBuilder().withKeyword(INDIVIDUAL).build();
		}
		String subj = consumeToken();
		OWLIndividual ind = getOWLIndividual(subj);
		if (!ind.isAnonymous()) {
			axioms.add(new OntologyAxiomPair(getOntology(null), dataFactory
					.getOWLDeclarationAxiom(ind.asOWLNamedIndividual())));
		}
		parseFrameSections(false, axioms, ind, individualFrameSections);
		return axioms;
	}

	@Nonnull
	protected OWLPropertyAssertionAxiom<?, ?> parseFact(
			@Nonnull OWLIndividual ind) {
		boolean negative = false;
		if (NOT.matches(peekToken())) {
			consumeToken();
			negative = true;
		}
		String prop = peekToken();
		if (isDataPropertyName(prop)) {
			OWLDataProperty p = parseDataProperty();
			OWLLiteral con = parseLiteral(null);
			if (!negative) {
				return dataFactory.getOWLDataPropertyAssertionAxiom(p, ind,
						con);
			} else {
				return dataFactory.getOWLNegativeDataPropertyAssertionAxiom(p,
						ind, con);
			}
		} else if (isObjectPropertyName(prop) || matches(INVERSE, prop)) {
			OWLObjectPropertyExpression p = parseObjectPropertyExpression(
					false);
			if (!negative) {
				return dataFactory.getOWLObjectPropertyAssertionAxiom(p, ind,
						parseIndividual());
			} else {
				return dataFactory.getOWLNegativeObjectPropertyAssertionAxiom(p,
						ind, parseIndividual());
			}
		} else {
			consumeToken();
			throw new ExceptionBuilder().withObject().withData().build();
		}
	}

	@Override
	public Set<OntologyAxiomPair> parseValuePartitionFrame() {
		String section = consumeToken();
		if (!matches(VALUE_PARTITION, section)) {
			throw new ExceptionBuilder().withKeyword(VALUE_PARTITION).build();
		}
		Set<OWLOntology> onts = getOntologies();
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		String clsName = consumeToken();
		if (eof(clsName)) {
			throw new ExceptionBuilder().withObject().build();
		}
		OWLClass cls = getOWLClass(clsName);
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		axioms.addAll(parseValuePartitionValues(onts, cls));
		for (OWLOntology ont : onts) {
			assert ont != null;
			axioms.add(new OntologyAxiomPair(ont,
					dataFactory.getOWLFunctionalObjectPropertyAxiom(prop)));
			axioms.add(new OntologyAxiomPair(ont,
					dataFactory.getOWLObjectPropertyRangeAxiom(prop, cls)));
		}
		return axioms;
	}

	@Nonnull
	private Set<OntologyAxiomPair> parseValuePartitionValues(
			@Nonnull Set<OWLOntology> onts, @Nonnull OWLClass superclass) {
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		Set<OWLClass> siblings = new HashSet<>();
		consumeToken(OPENBRACKET.keyword());
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			String clsName = consumeToken();
			OWLClass cls = getOWLClass(clsName);
			siblings.add(cls);
			OWLSubClassOfAxiom ax = dataFactory.getOWLSubClassOfAxiom(cls,
					superclass);
			for (OWLOntology ont : onts) {
				assert ont != null;
				axioms.add(new OntologyAxiomPair(ont, ax));
			}
			if (peekToken().equals(OPENBRACKET.keyword())) {
				axioms.addAll(parseValuePartitionValues(onts, cls));
			}
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		consumeToken(CLOSEBRACKET.keyword());
		OWLAxiom ax = dataFactory.getOWLDisjointClassesAxiom(siblings);
		for (OWLOntology ont : onts) {
			assert ont != null;
			axioms.add(new OntologyAxiomPair(ont, ax));
		}
		return axioms;
	}

	@Override
	public List<OntologyAxiomPair> parseRuleFrame() {
		String section = consumeToken();
		if (!matches(RULE, section)) {
			throw new ExceptionBuilder().withKeyword(RULE).build();
		}
		Set<OWLOntology> ontologies = getOntologies();
		List<SWRLAtom> body = parseRuleAtoms();
		String tok = consumeToken();
		if (!matches(DASH, tok)) {
			throw new ExceptionBuilder().withKeyword(DASH, COMMA).build();
		}
		consumeToken(">");
		List<SWRLAtom> head = parseRuleAtoms();
		SWRLRule rule = dataFactory.getSWRLRule(new LinkedHashSet<>(body),
				new LinkedHashSet<>(head));
		List<OntologyAxiomPair> pairs = new ArrayList<>();
		for (OWLOntology ont : ontologies) {
			assert ont != null;
			pairs.add(new OntologyAxiomPair(ont, rule));
		}
		return pairs;
	}

	private List<SWRLAtom> parseRuleAtoms() {
		String sep = COMMA.keyword();
		List<SWRLAtom> atoms = new ArrayList<>();
		while (matches(COMMA, sep)) {
			potentialKeywords.remove(COMMA);
			SWRLAtom atom = parseRuleAtom();
			atoms.add(atom);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
			potentialKeywords.add(COMMA);
		}
		return atoms;
	}

	private SWRLAtom parseRuleAtom() {
		String predicate = peekToken();
		if (isClassName(predicate)) {
			return parseClassAtom();
		} else if (matches(OPEN, predicate)) {
			return parseClassAtom();
		} else if (isObjectPropertyName(predicate)) {
			return parseObjectPropertyAtom();
		} else if (isDataPropertyName(predicate)) {
			return parseDataPropertyAtom();
		} else if (isDatatypeName(predicate)) {
			return parseDataRangeAtom();
		} else if (matches(DIFFERENT_FROM, predicate)) {
			return parseDifferentFromAtom();
		} else if (matches(SAME_AS, predicate)) {
			return parseSameAsAtom();
		} else if (isSWRLBuiltin(predicate) || predicate.startsWith("<")) {
			return parseBuiltInAtom();
		} else {
			consumeToken();
			List<String> kw = new ArrayList<>(ruleBuiltIns.keySet());
			kw.add(DIFFERENT_FROM.toString());
			kw.add(SAME_AS.toString());
			Collections.sort(kw);
			throw new ExceptionBuilder().withKeyword(kw).withClass()
					.withObject().withData().build();
		}
	}

	private SWRLAtom parseDataPropertyAtom() {
		String predicate = consumeToken();
		if (!isDataPropertyName(predicate)) {
			throw new ExceptionBuilder().withData().build();
		}
		consumeToken(OPEN.keyword());
		SWRLIArgument obj1 = parseIObject();
		consumeToken(COMMA.keyword());
		SWRLDArgument obj2 = parseDObject();
		consumeToken(CLOSE.keyword());
		return dataFactory.getSWRLDataPropertyAtom(
				getOWLDataProperty(predicate), obj1, obj2);
	}

	private SWRLAtom parseDataRangeAtom() {
		OWLDataRange range = parseDataRange();
		consumeToken(OPEN.keyword());
		SWRLVariable obj1 = parseDVariable();
		consumeToken(CLOSE.keyword());
		return dataFactory.getSWRLDataRangeAtom(range, obj1);
	}

	private SWRLAtom parseObjectPropertyAtom() {
		String predicate = consumeToken();
		if (!isObjectPropertyName(predicate)) {
			throw new ExceptionBuilder().withObject().build();
		}
		assert predicate != null;
		consumeToken(OPEN.keyword());
		SWRLIArgument obj1 = parseIObject();
		consumeToken(COMMA.keyword());
		SWRLIArgument obj2 = parseIObject();
		consumeToken(CLOSE.keyword());
		return dataFactory.getSWRLObjectPropertyAtom(
				getOWLObjectProperty(predicate), obj1, obj2);
	}

	private SWRLAtom parseClassAtom() {
		OWLClassExpression predicate = parseUnion();
		consumeToken(OPEN.keyword());
		SWRLIArgument obj = parseIObject();
		consumeToken(CLOSE.keyword());
		return dataFactory.getSWRLClassAtom(predicate, obj);
	}

	private SWRLDifferentIndividualsAtom parseDifferentFromAtom() {
		consumeToken(ManchesterOWLSyntax.DIFFERENT_FROM.toString());
		consumeToken(OPEN.keyword());
		SWRLIArgument obj1 = parseIObject();
		consumeToken(COMMA.keyword());
		SWRLIArgument obj2 = parseIObject();
		consumeToken(CLOSE.keyword());
		return dataFactory.getSWRLDifferentIndividualsAtom(obj1, obj2);
	}

	private SWRLSameIndividualAtom parseSameAsAtom() {
		consumeToken(ManchesterOWLSyntax.SAME_AS.toString());
		consumeToken(OPEN.keyword());
		SWRLIArgument obj1 = parseIObject();
		consumeToken(COMMA.keyword());
		SWRLIArgument obj2 = parseIObject();
		consumeToken(CLOSE.keyword());
		return dataFactory.getSWRLSameIndividualAtom(obj1, obj2);
	}

	@Nonnull
	private SWRLIArgument parseIObject() {
		String s = peekToken();
		if (isIndividualName(s)) {
			return parseIIndividualObject();
		} else if (s.equals("?")) {
			return parseIVariable();
		} else {
			consumeToken();
			throw new ExceptionBuilder().withInd().withKeyword("?$var$")
					.build();
		}
	}

	@Nonnull
	private SWRLVariable parseIVariable() {
		return dataFactory.getSWRLVariable(parseVariable());
	}

	@Nonnull
	private SWRLIndividualArgument parseIIndividualObject() {
		return dataFactory.getSWRLIndividualArgument(parseIndividual());
	}

	@Override
	public IRI parseVariable() {
		consumeToken("?");
		String fragment = peekToken();
		if (fragment.startsWith("<")) {
			// then the variable was saved with a full IRI
			// preserve the namespace
			return parseIRI();
		} else {
			consumeToken();
		}
		return IRI.create("urn:swrl#", fragment);
	}

	@Nonnull
	private SWRLDArgument parseDObject() {
		String s = peekToken();
		if (s.equals("?")) {
			return parseDVariable();
		} else {
			try {
				return parseLiteralObject();
			} catch (ParserException e) {
				e.getExpectedKeywords().add("?");
				throw e;
			}
		}
	}

	@Nonnull
	private SWRLVariable parseDVariable() {
		IRI var = parseVariable();
		return dataFactory.getSWRLVariable(var);
	}

	@Nonnull
	private SWRLLiteralArgument parseLiteralObject() {
		OWLLiteral lit = parseLiteral(null);
		return dataFactory.getSWRLLiteralArgument(lit);
	}

	private SWRLBuiltInAtom parseBuiltInAtom() {
		String predicate = consumeToken();
		consumeToken(OPEN.keyword());
		SWRLBuiltInsVocabulary v = null;
		IRI iri = null;
		if (!ruleBuiltIns.containsKey(predicate)) {
			iri = getIRI(predicate);
		} else {
			v = ruleBuiltIns.get(predicate);
			iri = v.getIRI();
		}
		List<SWRLDArgument> args = new ArrayList<>();
		if (v != null && v.getMaxArity() >= 0) {
			// We know the arity!
			for (int i = 0; i < v.getMaxArity(); i++) {
				SWRLDArgument obj = parseDObject();
				args.add(obj);
				// parse at least the minumum arity
				if (i < v.getMinArity() - 1) {
					consumeToken(COMMA.keyword());
				} else if (i < v.getMaxArity() - 1) {
					if (peekToken().equals(COMMA.keyword())) {
						consumeToken();
					} else {
						break;
					}
				}
			}
		} else {
			// Unknown arity so just parse as many arguments as we can
			String sep = COMMA.keyword();
			while (matches(COMMA, sep)) {
				SWRLDArgument arg = parseDObject();
				args.add(arg);
				sep = peekToken();
				if (matches(COMMA, sep)) {
					consumeToken();
				}
			}
		}
		consumeToken(CLOSE.keyword());
		return dataFactory.getSWRLBuiltInAtom(iri, args);
	}

	private Set<OntologyAxiomPair> parseDisjointClasses() {
		String section = consumeToken();
		if (!matches(DISJOINT_CLASSES, section)) {
			throw new ExceptionBuilder().withKeyword(DISJOINT_CLASSES).build();
		}
		Set<OWLOntology> ontologies = getOntologies();
		Set<OWLAnnotation> annotations = parseAnnotations();
		Set<OWLClassExpression> classExpressions = parseClassExpressionList();
		Set<OntologyAxiomPair> pairs = new HashSet<>();
		for (OWLOntology ont : ontologies) {
			assert ont != null;
			pairs.add(new OntologyAxiomPair(ont,
					dataFactory.getOWLDisjointClassesAxiom(classExpressions,
							annotations)));
		}
		return pairs;
	}

	private Set<OntologyAxiomPair> parseSameIndividual() {
		String section = consumeToken();
		if (!matches(SAME_INDIVIDUAL, section)) {
			throw new ExceptionBuilder().withKeyword(SAME_INDIVIDUAL).build();
		}
		Set<OWLIndividual> individuals = parseIndividualList();
		Set<OWLOntology> ontologies = getOntologies();
		Set<OWLAnnotation> annotations = parseAnnotations();
		Set<OntologyAxiomPair> pairs = new HashSet<>();
		for (OWLOntology ont : ontologies) {
			assert ont != null;
			pairs.add(new OntologyAxiomPair(ont, dataFactory
					.getOWLSameIndividualAxiom(individuals, annotations)));
		}
		return pairs;
	}

	private Set<OntologyAxiomPair> parseDisjointProperties() {
		String section = consumeToken();
		if (!matches(DISJOINT_PROPERTIES, section)) {
			throw new ExceptionBuilder().withKeyword(DISJOINT_PROPERTIES)
					.build();
		}
		Set<OWLOntology> ontologies = getOntologies();
		Set<OWLAnnotation> annotations = parseAnnotations();
		Set<OWLPropertyExpression> props = parsePropertyList();
		Set<OntologyAxiomPair> pairs = new HashSet<>();
		OWLAxiom propertiesAxiom;
		if (props.iterator().next().isObjectPropertyExpression()) {
			Set<OWLObjectPropertyExpression> ope = new HashSet<>();
			for (OWLPropertyExpression pe : props) {
				ope.add((OWLObjectPropertyExpression) pe);
			}
			propertiesAxiom = dataFactory
					.getOWLDisjointObjectPropertiesAxiom(ope, annotations);
		} else {
			Set<OWLDataPropertyExpression> dpe = new HashSet<>();
			for (OWLPropertyExpression pe : props) {
				dpe.add((OWLDataPropertyExpression) pe);
			}
			propertiesAxiom = dataFactory.getOWLDisjointDataPropertiesAxiom(dpe,
					annotations);
		}
		for (OWLOntology ont : ontologies) {
			assert ont != null;
			pairs.add(new OntologyAxiomPair(ont, propertiesAxiom));
		}
		return pairs;
	}

	private Set<OntologyAxiomPair> parseDifferentIndividuals() {
		String section = consumeToken();
		if (!matches(DIFFERENT_INDIVIDUALS, section)) {
			throw new ExceptionBuilder().withKeyword(DIFFERENT_INDIVIDUALS)
					.build();
		}
		Set<OWLOntology> ontologies = getOntologies();
		Set<OWLAnnotation> annotations = parseAnnotations();
		Set<OWLIndividual> individuals = parseIndividualList();
		Set<OntologyAxiomPair> pairs = new HashSet<>();
		for (OWLOntology ontology : ontologies) {
			assert ontology != null;
			pairs.add(new OntologyAxiomPair(ontology,
					dataFactory.getOWLDifferentIndividualsAxiom(individuals,
							annotations)));
		}
		return pairs;
	}

	@Nonnull
	protected OWLObjectPropertyCharacteristicAxiom parseObjectPropertyCharacteristic(
			@Nonnull OWLObjectPropertyExpression prop) {
		String characteristic = consumeToken();
		if (matches(FUNCTIONAL, characteristic)) {
			return dataFactory.getOWLFunctionalObjectPropertyAxiom(prop);
		} else if (matches(INVERSE_FUNCTIONAL, characteristic)) {
			return dataFactory.getOWLInverseFunctionalObjectPropertyAxiom(prop);
		} else if (matches(SYMMETRIC, characteristic)) {
			return dataFactory.getOWLSymmetricObjectPropertyAxiom(prop);
		} else if (matches(ANTI_SYMMETRIC, characteristic)
				|| matches(ASYMMETRIC, characteristic)) {
			return dataFactory.getOWLAsymmetricObjectPropertyAxiom(prop);
		} else if (matches(TRANSITIVE, characteristic)) {
			return dataFactory.getOWLTransitiveObjectPropertyAxiom(prop);
		} else if (matches(REFLEXIVE, characteristic)) {
			return dataFactory.getOWLReflexiveObjectPropertyAxiom(prop);
		} else if (matches(IRREFLEXIVE, characteristic)) {
			return dataFactory.getOWLIrreflexiveObjectPropertyAxiom(prop);
		} else {
			throw new ExceptionBuilder()
					.withKeyword(FUNCTIONAL, INVERSE_FUNCTIONAL, SYMMETRIC,
							ANTI_SYMMETRIC, TRANSITIVE, REFLEXIVE, IRREFLEXIVE)
					.build();
		}
	}

	@Nonnull
	protected OWLDataPropertyCharacteristicAxiom parseDataPropertyCharacteristic(
			@Nonnull OWLDataPropertyExpression prop) {
		String characteristic = consumeToken();
		if (matches(FUNCTIONAL, characteristic)) {
			return dataFactory.getOWLFunctionalDataPropertyAxiom(prop);
		} else {
			throw new ExceptionBuilder().withKeyword(FUNCTIONAL).build();
		}
	}

	@Override
	public Set<OWLClassExpression> parseClassExpressionList() {
		Set<OWLClassExpression> descs = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			potentialKeywords.remove(COMMA);
			descs.add(parseUnion());
			potentialKeywords.add(COMMA);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				sep = consumeToken();
			}
		}
		return descs;
	}

	private Set<OWLClassExpression> parseClassExpressionList(
			ManchesterOWLSyntax expectedOpen,
			ManchesterOWLSyntax expectedClose) {
		String open = consumeToken();
		Set<OWLClassExpression> descs = new HashSet<>();
		if (!matches(expectedOpen, open)) {
			throw new ExceptionBuilder().withKeyword(expectedOpen).build();
		}
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			potentialKeywords.remove(COMMA);
			OWLClassExpression desc = parseUnion();
			potentialKeywords.add(COMMA);
			descs.add(desc);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				sep = consumeToken();
			}
		}
		String close = consumeToken();
		if (!matches(expectedClose, close)) {
			throw new ExceptionBuilder().withKeyword(expectedClose).build();
		}
		return descs;
	}

	@Override
	public Set<OWLPropertyExpression> parsePropertyList() {
		Set<OWLPropertyExpression> props = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			OWLPropertyExpression prop = parsePropertyExpression();
			props.add(prop);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return props;
	}

	@Override
	public Set<OWLObjectPropertyExpression> parseObjectPropertyList() {
		Set<OWLObjectPropertyExpression> props = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			OWLObjectPropertyExpression prop = parseObjectPropertyExpression(
					false);
			props.add(prop);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return props;
	}

	@Override
	public Set<OWLDataProperty> parseDataPropertyList() {
		Set<OWLDataProperty> props = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			OWLDataProperty prop = parseDataProperty();
			props.add(prop);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return props;
	}

	@Override
	public Set<OWLAnnotationProperty> parseAnnotationPropertyList() {
		Set<OWLAnnotationProperty> props = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			OWLAnnotationProperty prop = parseAnnotationProperty();
			props.add(prop);
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return props;
	}

	@Override
	@Nonnull
	public Set<OWLIndividual> parseIndividualList() {
		Set<OWLIndividual> inds = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			inds.add(parseIndividual());
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return inds;
	}

	@Override
	public List<OWLObjectPropertyExpression> parseObjectPropertyChain() {
		String delim = "o";
		List<OWLObjectPropertyExpression> properties = new ArrayList<>();
		while (delim.equals("o")) {
			OWLObjectPropertyExpression prop = parseObjectPropertyExpression(
					false);
			properties.add(prop);
			delim = peekToken();
			if (delim.equals("o")) {
				consumeToken();
			}
		}
		return properties;
	}

	@Nonnull
	protected OWLIndividual parseIndividual() {
		String name = consumeToken();
		if (!isIndividualName(name) && !name.startsWith("_:")) {
			throw new ExceptionBuilder().withInd().build();
		}
		return getOWLIndividual(name);
	}

	@Nonnull
	protected OWLDataProperty parseDataProperty() {
		String name = consumeToken();
		if (!isDataPropertyName(name)) {
			throw new ExceptionBuilder().withData().build();
		}
		return getOWLDataProperty(name);
	}

	@Nonnull
	protected OWLAnnotationProperty parseAnnotationProperty() {
		String name = consumeToken();
		if (!isAnnotationPropertyName(name)) {
			throw new ExceptionBuilder().withAnn().build();
		}
		return getOWLAnnotationProperty(name);
	}

	private Map<String, IRI> parsePrefixDeclaration() {
		consumeToken(PREFIX);
		Map<String, IRI> map = new HashMap<>(2);
		String prefixName = consumeToken();
		// Handle legacy = character if necessart
		if (peekToken().equals("=")) {
			// Legacy
			consumeToken();
		}
		IRI iri = parseIRI();
		map.put(prefixName, iri);
		return map;
	}

	@Nonnull
	private OWLImportsDeclaration parseImportsDeclaration() {
		consumeToken(IMPORT);
		return dataFactory.getOWLImportsDeclaration(parseIRI());
	}

	@Nonnull
	protected IRI parseIRI() {
		String iriString = consumeToken();
		if (!(iriString.startsWith("<") && iriString.endsWith(">"))) {
			throw new ExceptionBuilder().withKeyword("<$IRI$>").build();
		}
		return IRI.create(iriString.substring(1, iriString.length() - 1));
	}

	private void processDeclaredEntities() {
		for (int i = 0; i < tokens.size(); i++) {
			String token = tokens.get(i).getToken();
			String name = null;
			if (i + 1 < tokens.size()) {
				name = tokens.get(i + 1).getToken();
			}
			if (matches(CLASS, token)) {
				if (name != null) {
					classNames.add(name);
				}
			} else if (matches(OBJECT_PROPERTY, token)) {
				if (name != null) {
					objectPropertyNames.add(name);
				}
			} else if (matches(DATA_PROPERTY, token)) {
				if (name != null) {
					dataPropertyNames.add(name);
				}
			} else if (matches(INDIVIDUAL, token)) {
				if (name != null) {
					individualNames.add(name);
				}
			} else if (matches(DATATYPE, token)) {
				if (name != null) {
					dataTypeNames.add(name);
				}
			} else if (matches(ANNOTATION_PROPERTY, token)) {
				if (name != null) {
					annotationPropertyNames.add(name);
				}
			} else if (matches(VALUE_PARTITION, token)) {
				if (name != null) {
					objectPropertyNames.add(name);
				}
				if (i + 2 < tokens.size()) {
					classNames.add(tokens.get(i + 2).getToken());
				}
			}
		}
	}

	private void processDeclaredEntities(OWLDeclarationAxiom ax) {
		ax.getEntity().accept(new OWLEntityVisitor() {

			@Override
			public void visit(OWLAnnotationProperty property) {
				annotationPropertyNames.add(pm.getShortForm(property.getIRI()));
			}

			@Override
			public void visit(OWLDatatype datatype) {
				dataTypeNames.add(pm.getShortForm(datatype.getIRI()));
			}

			@Override
			public void visit(OWLNamedIndividual individual) {
				individualNames.add(pm.getShortForm(individual.getIRI()));
			}

			@Override
			public void visit(OWLDataProperty property) {
				dataPropertyNames.add(pm.getShortForm(property.getIRI()));
			}

			@Override
			public void visit(OWLObjectProperty property) {
				objectPropertyNames.add(pm.getShortForm(property.getIRI()));
			}

			@Override
			public void visit(OWLClass cls) {
				classNames.add(pm.getShortForm(cls.getIRI()));
			}
		});
	}

	@Override
	public ManchesterSyntaxDocumentFormat parseOntology(
			@Nonnull OWLOntology ont) {
		Set<OntologyAxiomPair> axioms = new HashSet<>();
		OWLOntologyID ontologyID = new OWLOntologyID();
		Set<AddImport> imports = new HashSet<>();
		Set<AddOntologyAnnotation> ontologyAnnotations = new HashSet<>();
		defaultOntology = ont;
		processDeclaredEntities();
		while (true) {
			String section = peekToken();
			if (matches(ONTOLOGY, section)) {
				ManchesterOWLSyntaxOntologyHeader header = parseOntologyHeader(
						false);
				for (OWLImportsDeclaration decl : header
						.getImportsDeclarations()) {
					assert decl != null;
					imports.add(new AddImport(ont, decl));
					ont.getOWLOntologyManager().makeLoadImportRequest(decl,
							getOntologyLoaderConfiguration());
					OWLOntology imported = ont.getOWLOntologyManager()
							.getImportedOntology(decl);
					assert imported != null;
					for (OWLDeclarationAxiom declaration : imported
							.getAxioms(AxiomType.DECLARATION)) {
						processDeclaredEntities(declaration);
					}
				}
				for (OWLAnnotation anno : header.getAnnotations()) {
					assert anno != null;
					ontologyAnnotations
							.add(new AddOntologyAnnotation(ont, anno));
				}
				ontologyID = header.getOntologyID();
			} else if (matches(DISJOINT_CLASSES, section)) {
				axioms.addAll(parseDisjointClasses());
			} else if (matches(EQUIVALENT_CLASSES, section)) {
				axioms.addAll(parseNaryEquivalentClasses());
			} else if (matches(EQUIVALENT_PROPERTIES, section)) {
				axioms.addAll(parseNaryEquivalentProperties());
			} else if (matches(DISJOINT_PROPERTIES, section)) {
				axioms.addAll(parseDisjointProperties());
			} else if (matches(DIFFERENT_INDIVIDUALS, section)) {
				axioms.addAll(parseDifferentIndividuals());
			} else if (matches(SAME_INDIVIDUAL, section)) {
				axioms.addAll(parseSameIndividual());
			} else if (matches(CLASS, section)) {
				axioms.addAll(parseClassFrame());
			} else if (matches(OBJECT_PROPERTY, section)) {
				axioms.addAll(parseObjectPropertyFrame());
			} else if (matches(DATA_PROPERTY, section)) {
				axioms.addAll(parseDataPropertyFrame());
			} else if (matches(INDIVIDUAL, section)) {
				axioms.addAll(parseIndividualFrame());
			} else if (matches(DATATYPE, section)) {
				axioms.addAll(parseDatatypeFrame());
			} else if (matches(ANNOTATION_PROPERTY, section)) {
				axioms.addAll(parseAnnotationPropertyFrame());
			} else if (matches(VALUE_PARTITION, section)) {
				axioms.addAll(parseValuePartitionFrame());
			} else if (matches(IMPORT, section)) {
				OWLImportsDeclaration decl = parseImportsDeclaration();
				ont.getOWLOntologyManager().makeLoadImportRequest(decl,
						getOntologyLoaderConfiguration());
				imports.add(new AddImport(ont, decl));
				OWLOntology imported = ont.getOWLOntologyManager()
						.getImportedOntology(decl);
				assert imported != null;
				for (OWLDeclarationAxiom declaration : imported
						.getAxioms(AxiomType.DECLARATION)) {
					processDeclaredEntities(declaration);
				}
			} else if (matches(PREFIX, section)) {
				Map<String, IRI> nsMap = parsePrefixDeclaration();
				for (String ns : nsMap.keySet()) {
					assert ns != null;
					pm.setPrefix(ns, nsMap.get(ns).toString());
				}
			} else if (matches(RULE, section)) {
				axioms.addAll(parseRuleFrame());
			} else if (eof(section)) {
				break;
			} else {
				consumeToken();
				throw new ExceptionBuilder().withKeyword(CLASS, OBJECT_PROPERTY,
						DATA_PROPERTY, INDIVIDUAL, DATATYPE,
						ANNOTATION_PROPERTY, IMPORT, VALUE_PARTITION, PREFIX,
						EQUIVALENT_CLASSES, DISJOINT_CLASSES,
						DISJOINT_PROPERTIES, DIFFERENT_INDIVIDUALS,
						SAME_INDIVIDUAL).build();
			}
		}
		List<OWLOntologyChange> changes = new ArrayList<>(axioms.size());
		changes.addAll(imports);
		changes.addAll(ontologyAnnotations);
		for (OntologyAxiomPair pair : axioms) {
			changes.add(new AddAxiom(ont, pair.getAxiom()));
		}
		changes.add(new SetOntologyID(ont, ontologyID));
		ont.getOWLOntologyManager().applyChanges(changes);
		ManchesterSyntaxDocumentFormat format = new ManchesterSyntaxDocumentFormat();
		format.copyPrefixesFrom(pm);
		return format;
	}

	private ManchesterOWLSyntaxOntologyHeader parseOntologyHeader(
			boolean toEOF) {
		String tok = consumeToken();
		if (!matches(ONTOLOGY, tok)) {
			throw new ExceptionBuilder().withKeyword(ONTOLOGY).build();
		}
		IRI ontologyIRI = null;
		IRI versionIRI = null;
		if (peekToken().startsWith("<")) {
			ontologyIRI = parseIRI();
			if (peekToken().startsWith("<")) {
				versionIRI = parseIRI();
			}
		}
		Set<OWLAnnotation> annotations = new HashSet<>();
		Set<OWLImportsDeclaration> imports = new HashSet<>();
		while (true) {
			String section = peekToken();
			if (matches(IMPORT, section)) {
				consumeToken();
				tok = peekToken();
				Optional<IRI> importedIRI = Optional.absent();
				if (tok.startsWith("<")) {
					importedIRI = Optional.of(parseIRI());
				} else if (isOntologyName(tok)) {
					consumeToken();
					OWLOntology ont = getOntology(tok);
					if (ont != null) {
						importedIRI = ont.getOntologyID().getOntologyIRI();
					}
				} else {
					consumeToken();
					throw new ExceptionBuilder().withOnto()
							.withKeyword("<$ONTOLOGYYURI$>").build();
				}
				if (!importedIRI.isPresent()) {
					throw new ExceptionBuilder().withOnto()
							.withKeyword("Imported IRI is null").build();
				}
				IRI importedOntologyIRI = importedIRI.get();
				assert importedOntologyIRI != null;
				imports.add(dataFactory
						.getOWLImportsDeclaration(importedOntologyIRI));
			} else if (matches(ANNOTATIONS, section)) {
				consumeToken();
				annotations.addAll(parseAnnotationList());
			} else if (eof(section)) {
				break;
			} else if (toEOF) {
				throw new ExceptionBuilder().withKeyword(IMPORT, ANNOTATIONS)
						.build();
			} else {
				break;
			}
		}
		return new ManchesterOWLSyntaxOntologyHeader(ontologyIRI, versionIRI,
				annotations, imports);
	}

	protected class ExceptionBuilder {

		boolean ontologyNameExpected = false;
		boolean classNameExpected = false;
		boolean objectPropertyNameExpected = false;
		boolean dataPropertyNameExpected = false;
		boolean individualNameExpected = false;
		boolean datatypeNameExpected = false;
		boolean annotationPropertyNameExpected = false;
		boolean integerExpected = false;
		Set<String> keywords = new HashSet<>();
		List<String> tokenSequence;
		int start = -1;
		int line = -1;
		int column = -1;

		ExceptionBuilder() {
			withKeyword(potentialKeywords);
		}

		ExceptionBuilder(ParserException e) {
			ontologyNameExpected = e.isOntologyNameExpected();
			classNameExpected = e.isClassNameExpected();
			objectPropertyNameExpected = e.isObjectPropertyNameExpected();
			dataPropertyNameExpected = e.isDataPropertyNameExpected();
			individualNameExpected = e.isIndividualNameExpected();
			dataPropertyNameExpected = e.isDatatypeNameExpected();
			annotationPropertyNameExpected = e
					.isAnnotationPropertyNameExpected();
			integerExpected = e.isIntegerExpected();
			withKeyword(e.getExpectedKeywords());
			tokenSequence = e.getTokenSequence();
			start = e.getStartPos();
			line = e.getLineNumber();
			column = e.getColumnNumber();
		}

		public ExceptionBuilder withOnto() {
			ontologyNameExpected = true;
			return this;
		}

		public ExceptionBuilder withInt() {
			integerExpected = true;
			return this;
		}

		public ExceptionBuilder withClass() {
			classNameExpected = true;
			return this;
		}

		public ExceptionBuilder withObject() {
			objectPropertyNameExpected = true;
			withKeyword(INVERSE);
			return this;
		}

		public ExceptionBuilder withData() {
			dataPropertyNameExpected = true;
			return this;
		}

		public ExceptionBuilder withInd() {
			individualNameExpected = true;
			return this;
		}

		public ExceptionBuilder withDt() {
			datatypeNameExpected = true;
			return this;
		}

		public ExceptionBuilder withAnn() {
			annotationPropertyNameExpected = true;
			return this;
		}

		public ExceptionBuilder withKeyword(String s) {
			keywords.add(s);
			return this;
		}

		public ExceptionBuilder withKeyword(ManchesterOWLSyntax s) {
			keywords.add(s.keyword());
			return this;
		}

		public ExceptionBuilder withKeyword(String... strings) {
			for (String s : strings) {
				keywords.add(s);
			}
			return this;
		}

		public ExceptionBuilder withKeyword(ManchesterOWLSyntax... keys) {
			for (ManchesterOWLSyntax s : keys) {
				keywords.add(s.keyword());
			}
			return this;
		}

		public <T> ExceptionBuilder withKeyword(Collection<T> keys) {
			for (T s : keys) {
				if (s instanceof String) {
					withKeyword((String) s);
				}
				if (s instanceof ManchesterOWLSyntax) {
					withKeyword((ManchesterOWLSyntax) s);
				}
			}
			return this;
		}

		public ParserException build() {
			if (tokenSequence == null) {
				Token lastToken = getLastToken();
				tokenSequence = getTokenSequence();
				start = lastToken.getPos();
				line = lastToken.getRow();
				column = lastToken.getCol();
			}
			return new ParserException(tokenSequence, start, line, column,
					ontologyNameExpected, classNameExpected,
					objectPropertyNameExpected, dataPropertyNameExpected,
					individualNameExpected, datatypeNameExpected,
					annotationPropertyNameExpected, integerExpected, keywords);
		}
	}

	protected List<String> getTokenSequence() {
		List<String> seq = new ArrayList<>();
		int index = tokenIndex - 1;
		if (index < 0) {
			index = 0;
		}
		while (index < tokens.size() && seq.size() < 4 && !seq.contains(EOF)) {
			seq.add(tokens.get(index).getToken());
			index++;
		}
		if (seq.isEmpty()) {
			seq.add(EOF);
		}
		return seq;
	}

	class DefaultEntityChecker implements OWLEntityChecker {

		@Override
		public OWLClass getOWLClass(String name) {
			if (name.equals("Thing") || name.equals("owl:Thing")) {
				return dataFactory.getOWLThing();
			} else if (name.equals("Nothing") || name.equals("owl:Nothing")) {
				return dataFactory.getOWLNothing();
			} else if (classNames.contains(name)) {
				return dataFactory.getOWLClass(getIRI(name));
			}
			return null;
		}

		@Override
		public OWLObjectProperty getOWLObjectProperty(String name) {
			if (objectPropertyNames.contains(name)) {
				return dataFactory.getOWLObjectProperty(getIRI(name));
			}
			return null;
		}

		@Override
		public OWLDataProperty getOWLDataProperty(String name) {
			if (dataPropertyNames.contains(name)) {
				return dataFactory.getOWLDataProperty(getIRI(name));
			}
			return null;
		}

		@Override
		public OWLNamedIndividual getOWLIndividual(String name) {
			if (individualNames.contains(name)) {
				return dataFactory.getOWLNamedIndividual(getIRI(name));
			}
			return null;
		}

		@Override
		public OWLDatatype getOWLDatatype(String name) {
			if (dataTypeNames.contains(name)) {
				return dataFactory.getOWLDatatype(getIRI(name));
			}
			return null;
		}

		@Override
		public OWLAnnotationProperty getOWLAnnotationProperty(String name) {
			if (annotationPropertyNames.contains(name)) {
				return dataFactory.getOWLAnnotationProperty(getIRI(name));
			}
			return null;
		}
	}

	private final Map<String, IRI> nameIRIMap = new HashMap<>();

	@Nonnull
	protected IRI getIRI(@Nonnull String inputName) {
		String name = inputName;
		boolean fullIRI = name.equals("<");
		if (fullIRI) {
			name = consumeToken();
			consumeToken();
		}
		IRI uri = nameIRIMap.get(name);
		if (uri != null) {
			return uri;
		}
		if (fullIRI) {
			uri = IRI.create(name);
		} else {
			int colonIndex = name.indexOf(':');
			if (colonIndex == -1) {
				name = ":" + name;
			}
			uri = pm.getIRI(name);
		}
		nameIRIMap.put(name, uri);
		return uri;
	}

	@Override
	public OWLAxiom parseAxiom() {
		String token = peekToken();
		if (isClassName(token)) {
			return parseAxiomWithClassExpressionStart();
		} else if (isObjectPropertyName(token)) {
			return parseAxiomWithObjectPropertyStart();
		} else if (isDataPropertyName(token)) {
			return parseAxiomWithDataPropertyStart();
		} else if (isIndividualName(token)) {
			return parseAxiomWithIndividualStart();
		} else if (matches(INV, token)) {
			return parseAxiomWithObjectPropertyStart();
		} else if (matches(OPEN, token)) {
			return parseAxiomWithClassExpressionStart();
		} else if (matches(OPENBRACE, token)) {
			return parseAxiomWithClassExpressionStart();
		} else if (matches(FUNCTIONAL, token)) {
			return parseFunctionPropertyAxiom();
		} else if (matches(INVERSE_FUNCTIONAL, token)) {
			return parseInverseFunctionalPropertyAxiom();
		} else if (matches(SYMMETRIC, token)) {
			return parseSymmetricPropertyAxiom();
		} else if (matches(ASYMMETRIC, token)) {
			return parseAsymmetricPropertyAxiom();
		} else if (matches(TRANSITIVE, token)) {
			return parseTransitivePropertyAxiom();
		} else if (matches(REFLEXIVE, token)) {
			return parseReflexivePropertyAxiom();
		} else if (matches(IRREFLEXIVE, token)) {
			return parseIrreflexivePropertyAxiom();
		}
		throw new ExceptionBuilder().withClass().withObject().withData()
				.withKeyword(OPEN, OPENBRACE, INV, FUNCTIONAL,
						INVERSE_FUNCTIONAL, SYMMETRIC, ASYMMETRIC, TRANSITIVE,
						REFLEXIVE, IRREFLEXIVE)
				.build();
	}

	@Override
	public OWLClassAxiom parseClassAxiom() {
		return (OWLClassAxiom) parseAxiom();
	}

	@Nonnull
	private OWLAxiom parseAxiomWithIndividualStart() {
		OWLIndividual ind = parseIndividual();
		String kw = consumeToken();
		if (matches(TYPE, kw)) {
			OWLClassExpression type = parseClassExpression();
			return dataFactory.getOWLClassAssertionAxiom(type, ind);
		}
		throw new ExceptionBuilder().withKeyword(TYPE).build();
	}

	@Nonnull
	private OWLAxiom parseAxiomWithDataPropertyStart() {
		OWLDataPropertyExpression prop = parseDataProperty();
		String kw = consumeToken();
		if (matches(SOME, kw)) {
			OWLDataRange dataRange = parseDataIntersectionOf();
			return parseClassAxiomRemainder(
					dataFactory.getOWLDataSomeValuesFrom(prop, dataRange));
		} else if (matches(ONLY, kw)) {
			OWLDataRange dataRange = parseDataIntersectionOf();
			return parseClassAxiomRemainder(
					dataFactory.getOWLDataAllValuesFrom(prop, dataRange));
		} else if (matches(MIN, kw)) {
			int cardi = parseInteger();
			OWLDataRange dataRange = parseDataIntersectionOf();
			return parseClassAxiomRemainder(dataFactory
					.getOWLDataMinCardinality(cardi, prop, dataRange));
		} else if (matches(MAX, kw)) {
			int cardi = parseInteger();
			OWLDataRange dataRange = parseDataIntersectionOf();
			return parseClassAxiomRemainder(dataFactory
					.getOWLDataMaxCardinality(cardi, prop, dataRange));
		} else if (matches(EXACTLY, kw)) {
			int cardi = parseInteger();
			OWLDataRange dataRange = parseDataIntersectionOf();
			return parseClassAxiomRemainder(dataFactory
					.getOWLDataExactCardinality(cardi, prop, dataRange));
		} else if (matches(SUB_PROPERTY_OF, kw)) {
			OWLDataPropertyExpression superProperty = parseDataPropertyExpression();
			return dataFactory.getOWLSubDataPropertyOfAxiom(prop,
					superProperty);
		} else if (matches(EQUIVALENT_TO, kw)) {
			OWLDataPropertyExpression equivProp = parseDataPropertyExpression();
			return dataFactory.getOWLEquivalentDataPropertiesAxiom(prop,
					equivProp);
		} else if (matches(DISJOINT_WITH, kw)) {
			OWLDataPropertyExpression disjProp = parseDataPropertyExpression();
			return dataFactory.getOWLDisjointDataPropertiesAxiom(prop,
					disjProp);
		} else if (matches(DOMAIN, kw)) {
			OWLClassExpression domain = parseClassExpression();
			return dataFactory.getOWLDataPropertyDomainAxiom(prop, domain);
		} else if (matches(RANGE, kw)) {
			OWLDataRange range = parseDataRange();
			return dataFactory.getOWLDataPropertyRangeAxiom(prop, range);
		} else {
			throw new ExceptionBuilder()
					.withKeyword(SOME, ONLY, MIN, MAX, EXACTLY, SUB_PROPERTY_OF,
							EQUIVALENT_TO, DISJOINT_WITH, DOMAIN, RANGE)
					.build();
		}
	}

	@Nonnull
	private OWLDataPropertyExpression parseDataPropertyExpression() {
		String tok = consumeToken();
		if (!isDataPropertyName(tok)) {
			throw new ExceptionBuilder().withData().build();
		}
		return getOWLDataProperty(tok);
	}

	@Nonnull
	private OWLAxiom parseAxiomWithClassExpressionStart() {
		return parseClassAxiomRemainder(parseUnion());
	}

	@Nonnull
	private OWLAxiom parseClassAxiomRemainder(
			@Nonnull OWLClassExpression startExpression) {
		String kw = consumeToken();
		if (matches(SUBCLASS_OF, kw)) {
			OWLClassExpression superClass = parseClassExpression();
			return dataFactory.getOWLSubClassOfAxiom(startExpression,
					superClass);
		} else if (matches(DISJOINT_WITH, kw)) {
			OWLClassExpression disjointClass = parseClassExpression();
			return dataFactory.getOWLDisjointClassesAxiom(startExpression,
					disjointClass);
		} else if (matches(EQUIVALENT_TO, kw)) {
			OWLClassExpression equivClass = parseClassExpression();
			return dataFactory.getOWLEquivalentClassesAxiom(startExpression,
					equivClass);
		} else if (matches(AND, kw)) {
			OWLClassExpression conjunct = parseIntersection();
			Set<OWLClassExpression> conjuncts = conjunct.asConjunctSet();
			conjuncts.add(startExpression);
			OWLClassExpression ce = dataFactory
					.getOWLObjectIntersectionOf(conjuncts);
			return parseClassAxiomRemainder(ce);
		} else if (matches(OR, kw)) {
			OWLClassExpression disjunct = parseUnion();
			Set<OWLClassExpression> disjuncts = disjunct.asDisjunctSet();
			disjuncts.add(startExpression);
			OWLClassExpression ce = dataFactory.getOWLObjectUnionOf(disjuncts);
			return parseClassAxiomRemainder(ce);
		} else {
			throw new ExceptionBuilder().withKeyword(SUBCLASS_OF, DISJOINT_WITH,
					EQUIVALENT_TO, AND, OR).build();
		}
	}

	@Nonnull
	private OWLAxiom parseAxiomWithObjectPropertyStart() {
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		String kw = consumeToken();
		if (matches(SOME, kw)) {
			OWLClassExpression filler = parseUnion();
			return parseClassAxiomRemainder(
					dataFactory.getOWLObjectSomeValuesFrom(prop, filler));
		} else if (matches(ONLY, kw)) {
			OWLClassExpression filler = parseUnion();
			return parseClassAxiomRemainder(
					dataFactory.getOWLObjectAllValuesFrom(prop, filler));
		} else if (matches(MIN, kw)) {
			int cardi = parseInteger();
			OWLClassExpression filler = parseUnion();
			return parseClassAxiomRemainder(dataFactory
					.getOWLObjectMinCardinality(cardi, prop, filler));
		} else if (matches(MAX, kw)) {
			int cardi = parseInteger();
			OWLClassExpression filler = parseUnion();
			return parseClassAxiomRemainder(dataFactory
					.getOWLObjectMaxCardinality(cardi, prop, filler));
		} else if (matches(EXACTLY, kw)) {
			int cardi = parseInteger();
			OWLClassExpression filler = parseUnion();
			return parseClassAxiomRemainder(dataFactory
					.getOWLObjectExactCardinality(cardi, prop, filler));
		} else if (matches(SUB_PROPERTY_OF, kw)) {
			OWLObjectPropertyExpression superProperty = parseObjectPropertyExpression(
					false);
			return dataFactory.getOWLSubObjectPropertyOfAxiom(prop,
					superProperty);
		} else if (matches(EQUIVALENT_TO, kw)) {
			OWLObjectPropertyExpression equivProp = parseObjectPropertyExpression(
					false);
			return dataFactory.getOWLEquivalentObjectPropertiesAxiom(prop,
					equivProp);
		} else if (matches(INVERSE_OF, kw)) {
			OWLObjectPropertyExpression invProp = parseObjectPropertyExpression(
					false);
			return dataFactory.getOWLInverseObjectPropertiesAxiom(prop,
					invProp);
		} else if (matches(DISJOINT_WITH, kw)) {
			OWLObjectPropertyExpression disjProp = parseObjectPropertyExpression(
					false);
			return dataFactory.getOWLDisjointObjectPropertiesAxiom(prop,
					disjProp);
		} else if (matches(DOMAIN, kw)) {
			OWLClassExpression domain = parseClassExpression();
			return dataFactory.getOWLObjectPropertyDomainAxiom(prop, domain);
		} else if (matches(RANGE, kw)) {
			OWLClassExpression range = parseClassExpression();
			return dataFactory.getOWLObjectPropertyRangeAxiom(prop, range);
		} else if (matches(CHAIN_CONNECT, kw)) {
			String sep = kw;
			List<OWLObjectPropertyExpression> chain = new ArrayList<>();
			chain.add(prop);
			while (sep.equals("o")) {
				OWLObjectPropertyExpression chainProp = parseObjectPropertyExpression(
						false);
				chain.add(chainProp);
				sep = consumeToken();
			}
			if (!matches(SUB_PROPERTY_OF, sep)) {
				throw new ExceptionBuilder().withKeyword(SUB_PROPERTY_OF)
						.build();
			}
			OWLObjectPropertyExpression superProp = parseObjectPropertyExpression(
					false);
			return dataFactory.getOWLSubPropertyChainOfAxiom(chain, superProp);
		} else {
			throw new ExceptionBuilder().withKeyword(SOME, ONLY, MIN, MAX,
					EXACTLY, SUB_PROPERTY_OF, EQUIVALENT_TO, INVERSE_OF,
					DISJOINT_WITH, DOMAIN, RANGE, CHAIN_CONNECT).build();
		}
	}

	@Nonnull
	private OWLAxiom parseInverseFunctionalPropertyAxiom() {
		String kw = consumeToken();
		if (!matches(INVERSE_FUNCTIONAL, kw)) {
			throw new ExceptionBuilder().withKeyword(INVERSE_FUNCTIONAL)
					.build();
		}
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		return dataFactory.getOWLInverseFunctionalObjectPropertyAxiom(prop);
	}

	@Nonnull
	private OWLAxiom parseSymmetricPropertyAxiom() {
		String kw = consumeToken();
		if (!matches(SYMMETRIC, kw)) {
			throw new ExceptionBuilder().withKeyword(SYMMETRIC).build();
		}
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		return dataFactory.getOWLSymmetricObjectPropertyAxiom(prop);
	}

	@Nonnull
	private OWLAxiom parseAsymmetricPropertyAxiom() {
		String kw = consumeToken();
		if (!matches(ASYMMETRIC, kw)) {
			throw new ExceptionBuilder().withKeyword(ASYMMETRIC).build();
		}
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		return dataFactory.getOWLAsymmetricObjectPropertyAxiom(prop);
	}

	@Nonnull
	private OWLAxiom parseTransitivePropertyAxiom() {
		String kw = consumeToken();
		if (!matches(TRANSITIVE, kw)) {
			throw new ExceptionBuilder().withKeyword(TRANSITIVE).build();
		}
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		return dataFactory.getOWLTransitiveObjectPropertyAxiom(prop);
	}

	@Nonnull
	private OWLAxiom parseReflexivePropertyAxiom() {
		String kw = consumeToken();
		if (!matches(REFLEXIVE, kw)) {
			throw new ExceptionBuilder().withKeyword(REFLEXIVE).build();
		}
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		return dataFactory.getOWLReflexiveObjectPropertyAxiom(prop);
	}

	@Nonnull
	private OWLAxiom parseIrreflexivePropertyAxiom() {
		String kw = consumeToken();
		if (!matches(IRREFLEXIVE, kw)) {
			throw new ExceptionBuilder().withKeyword(IRREFLEXIVE).build();
		}
		OWLObjectPropertyExpression prop = parseObjectPropertyExpression(false);
		return dataFactory.getOWLIrreflexiveObjectPropertyAxiom(prop);
	}

	@Nonnull
	private OWLAxiom parseFunctionPropertyAxiom() {
		String kw = consumeToken();
		if (!matches(FUNCTIONAL, kw)) {
			throw new ExceptionBuilder().withKeyword(FUNCTIONAL).build();
		}
		String name = peekToken();
		if (isObjectPropertyName(name)) {
			OWLObjectPropertyExpression prop = parseObjectPropertyExpression(
					false);
			return dataFactory.getOWLFunctionalObjectPropertyAxiom(prop);
		} else if (isDataPropertyName(name)) {
			OWLDataProperty prop = parseDataProperty();
			return dataFactory.getOWLFunctionalDataPropertyAxiom(prop);
		} else {
			consumeToken();
			throw new ExceptionBuilder().withObject().withData().build();
		}
	}

	@Nonnull
	private <F, O> Set<OntologyAxiomPair> parseAnnotatedListItems(@Nonnull F s,
			@Nonnull AnnotatedListItemParser<F, O> itemParser,
			@Nonnull Set<OWLOntology> ontologies) {
		Set<OntologyAxiomPair> result = new HashSet<>();
		String sep = COMMA.keyword();
		while (matches(COMMA, sep)) {
			Set<OWLAnnotation> annotations = parseAnnotations();
			O item = itemParser.parseItem(s);
			OWLAxiom axiom = itemParser.createAxiom(s, item, annotations);
			for (OWLOntology ontology : ontologies) {
				result.add(new OntologyAxiomPair(ontology, axiom));
			}
			sep = peekToken();
			if (matches(COMMA, sep)) {
				consumeToken();
			}
		}
		return result;
	}

	interface AnnotatedListItemParser<F, O> {

		@Nonnull
		O parseItem(@Nonnull F s);

		@Nonnull
		OWLAxiom createAxiom(@Nonnull F s, @Nonnull O o,
				@Nonnull Set<OWLAnnotation> anns);

		ManchesterOWLSyntax getFrameSectionKeyword();
	}

	abstract class AnnotatedClassExpressionListItemParser<F>
			implements AnnotatedListItemParser<F, OWLClassExpression> {

		@Override
		public OWLClassExpression parseItem(F s) {
			return parseUnion();
		}
	}

	abstract class AnnotatedClassExpressionSetListItemParser<F>
			implements AnnotatedListItemParser<F, Set<OWLClassExpression>> {

		@Override
		public Set<OWLClassExpression> parseItem(F s) {
			return parseClassExpressionList();
		}
	}

	abstract class AnnotatedPropertyListListItemParser<F>
			implements AnnotatedListItemParser<F, Set<OWLPropertyExpression>> {

		@Override
		public Set<OWLPropertyExpression> parseItem(F s) {
			return parsePropertyList();
		}
	}

	abstract class AnnotatedIndividualsListItemParser<F>
			implements AnnotatedListItemParser<F, OWLIndividual> {

		@Override
		public OWLIndividual parseItem(F s) {
			return parseIndividual();
		}
	}

	abstract class AnnotationListItemParser<F>
			implements AnnotatedListItemParser<F, OWLAnnotation> {

		@Override
		public OWLAnnotation parseItem(F s) {
			return parseAnnotation();
		}
	}

	class ClassSubClassOfListItemParser
			extends AnnotatedClassExpressionListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLSubClassOfAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SUBCLASS_OF;
		}
	}

	class ClassEquivalentToListItemParser
			extends AnnotatedClassExpressionListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLEquivalentClassesAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return EQUIVALENT_TO;
		}
	}

	class ClassDisjointWithListItemParser
			extends AnnotatedClassExpressionListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			Set<OWLClassExpression> disjointClasses = new HashSet<>();
			disjointClasses.add(s);
			disjointClasses.add(o);
			return dataFactory.getOWLDisjointClassesAxiom(disjointClasses,
					anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DISJOINT_WITH;
		}
	}

	class ClassDisjointClassesListItemParser
			extends AnnotatedClassExpressionSetListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, Set<OWLClassExpression> o,
				Set<OWLAnnotation> anns) {
			// o.add(s);
			return dataFactory.getOWLDisjointClassesAxiom(o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DISJOINT_CLASSES;
		}
	}

	class ClassDisjointUnionOfListItemParser
			extends AnnotatedClassExpressionSetListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, Set<OWLClassExpression> o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLDisjointUnionAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DISJOINT_UNION_OF;
		}
	}

	class ClassHasKeyListItemParser
			extends AnnotatedPropertyListListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, Set<OWLPropertyExpression> o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLHasKeyAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return HAS_KEY;
		}
	}

	class ClassSuperClassOfListItemParser
			extends AnnotatedClassExpressionListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLSubClassOfAxiom(o, s, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SUPERCLASS_OF;
		}
	}

	class ClassIndividualsListItemParser
			extends AnnotatedIndividualsListItemParser<OWLClass> {

		@Override
		public OWLAxiom createAxiom(OWLClass s, OWLIndividual o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLClassAssertionAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return INDIVIDUALS;
		}
	}

	class EntityAnnotationsListItemParser<E extends OWLEntity>
			extends AnnotationListItemParser<E> {

		@Override
		public OWLAxiom createAxiom(E s, OWLAnnotation o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLAnnotationAssertionAxiom(s.getIRI(), o,
					anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return ANNOTATIONS;
		}
	}

	abstract class ObjectPropertyExpressionListItemParser<F>
			implements AnnotatedListItemParser<F, OWLObjectPropertyExpression> {

		@Override
		public OWLObjectPropertyExpression parseItem(F s) {
			return parseObjectPropertyExpression(false);
		}
	}

	class ObjectPropertySubPropertyOfListItemParser
			extends ObjectPropertyExpressionListItemParser<OWLObjectProperty> {

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s,
				OWLObjectPropertyExpression o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLSubObjectPropertyOfAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SUB_PROPERTY_OF;
		}
	}

	class ObjectPropertySuperPropertyOfListItemParser
			extends ObjectPropertyExpressionListItemParser<OWLObjectProperty> {

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s,
				OWLObjectPropertyExpression o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLSubObjectPropertyOfAxiom(o, s, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SUPER_PROPERTY_OF;
		}
	}

	class ObjectPropertyEquivalentToListItemParser
			extends ObjectPropertyExpressionListItemParser<OWLObjectProperty> {

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s,
				OWLObjectPropertyExpression o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLEquivalentObjectPropertiesAxiom(s, o,
					anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return EQUIVALENT_TO;
		}
	}

	class ObjectPropertyDisjointWithListItemParser
			extends ObjectPropertyExpressionListItemParser<OWLObjectProperty> {

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s,
				OWLObjectPropertyExpression o, Set<OWLAnnotation> anns) {
			Set<OWLObjectPropertyExpression> properties = new HashSet<>();
			properties.add(s);
			properties.add(o);
			return dataFactory.getOWLDisjointObjectPropertiesAxiom(properties,
					anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DISJOINT_WITH;
		}
	}

	class ObjectPropertyDomainListItemParser
			extends AnnotatedClassExpressionListItemParser<OWLObjectProperty> {

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLObjectPropertyDomainAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DOMAIN;
		}
	}

	class ObjectPropertyRangeListItemParser
			extends AnnotatedClassExpressionListItemParser<OWLObjectProperty> {

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLObjectPropertyRangeAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return RANGE;
		}
	}

	class ObjectPropertyInverseOfListItemParser
			extends ObjectPropertyExpressionListItemParser<OWLObjectProperty> {

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s,
				OWLObjectPropertyExpression o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLInverseObjectPropertiesAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return INVERSE_OF;
		}
	}

	class ObjectPropertySubPropertyChainListItemParser implements
			AnnotatedListItemParser<OWLObjectProperty, List<OWLObjectPropertyExpression>> {

		@Override
		public List<OWLObjectPropertyExpression> parseItem(
				OWLObjectProperty s) {
			return parseObjectPropertyChain();
		}

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s,
				List<OWLObjectPropertyExpression> o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLSubPropertyChainOfAxiom(o, s, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SUB_PROPERTY_CHAIN;
		}
	}

	class ObjectPropertyCharacteristicsItemParser implements
			AnnotatedListItemParser<OWLObjectProperty, OWLObjectPropertyCharacteristicAxiom> {

		@Override
		public OWLObjectPropertyCharacteristicAxiom parseItem(
				@Nonnull OWLObjectProperty s) {
			return parseObjectPropertyCharacteristic(s);
		}

		@Override
		public OWLAxiom createAxiom(OWLObjectProperty s,
				OWLObjectPropertyCharacteristicAxiom o,
				Set<OWLAnnotation> anns) {
			return o.getAnnotatedAxiom(anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return CHARACTERISTICS;
		}
	}

	abstract class DataPropertyExpressionListItemParser<F>
			implements AnnotatedListItemParser<F, OWLDataPropertyExpression> {

		@Override
		public OWLDataProperty parseItem(F s) {
			return parseDataProperty();
		}
	}

	class DataPropertySubPropertyOfListItemParser
			extends DataPropertyExpressionListItemParser<OWLDataProperty> {

		@Override
		public OWLAxiom createAxiom(OWLDataProperty s,
				OWLDataPropertyExpression o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLSubDataPropertyOfAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SUB_PROPERTY_OF;
		}
	}

	class DataPropertyEquivalentToListItemParser
			extends DataPropertyExpressionListItemParser<OWLDataProperty> {

		@Override
		public OWLAxiom createAxiom(OWLDataProperty s,
				OWLDataPropertyExpression o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLEquivalentDataPropertiesAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return EQUIVALENT_TO;
		}
	}

	class DataPropertyDisjointWithListItemParser
			extends DataPropertyExpressionListItemParser<OWLDataProperty> {

		@Override
		public OWLAxiom createAxiom(OWLDataProperty s,
				OWLDataPropertyExpression o, Set<OWLAnnotation> anns) {
			Set<OWLDataPropertyExpression> properties = new HashSet<>();
			properties.add(s);
			properties.add(o);
			return dataFactory.getOWLDisjointDataPropertiesAxiom(properties,
					anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DISJOINT_WITH;
		}
	}

	class DataPropertyDomainListItemParser
			extends AnnotatedClassExpressionListItemParser<OWLDataProperty> {

		@Override
		public OWLAxiom createAxiom(OWLDataProperty s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLDataPropertyDomainAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DOMAIN;
		}
	}

	abstract class AnnotatedDataRangeListItemParser<F>
			implements AnnotatedListItemParser<F, OWLDataRange> {

		@Override
		public OWLDataRange parseItem(F s) {
			return parseDataRange();
		}
	}

	class DataPropertyRangeListItemParser
			extends AnnotatedDataRangeListItemParser<OWLDataProperty> {

		@Override
		public OWLAxiom createAxiom(OWLDataProperty s, OWLDataRange o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLDataPropertyRangeAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return RANGE;
		}
	}

	class DataPropertyCharacteristicsItemParser implements
			AnnotatedListItemParser<OWLDataProperty, OWLDataPropertyCharacteristicAxiom> {

		@Override
		public OWLDataPropertyCharacteristicAxiom parseItem(OWLDataProperty s) {
			return parseDataPropertyCharacteristic(s);
		}

		@Override
		public OWLAxiom createAxiom(OWLDataProperty s,
				OWLDataPropertyCharacteristicAxiom o, Set<OWLAnnotation> anns) {
			return o.getAnnotatedAxiom(anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return CHARACTERISTICS;
		}
	}

	class IndividualTypesItemParser
			extends AnnotatedClassExpressionListItemParser<OWLIndividual> {

		@Override
		public OWLAxiom createAxiom(OWLIndividual s, OWLClassExpression o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLClassAssertionAxiom(o, s, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return TYPES;
		}
	}

	class IndividualFactsItemParser implements
			AnnotatedListItemParser<OWLIndividual, OWLPropertyAssertionAxiom<?, ?>> {

		@Override
		public OWLPropertyAssertionAxiom<?, ?> parseItem(OWLIndividual s) {
			return parseFact(s);
		}

		@Override
		public OWLAxiom createAxiom(@Nonnull OWLIndividual s,
				OWLPropertyAssertionAxiom<?, ?> o, Set<OWLAnnotation> anns) {
			return o.getAnnotatedAxiom(anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return FACTS;
		}
	}

	class IndividualSameAsItemParser
			extends AnnotatedIndividualsListItemParser<OWLIndividual> {

		@Override
		public OWLAxiom createAxiom(OWLIndividual s, OWLIndividual o,
				@Nonnull Set<OWLAnnotation> anns) {
			Set<OWLIndividual> individuals = new HashSet<>();
			individuals.add(s);
			individuals.add(o);
			return dataFactory.getOWLSameIndividualAxiom(individuals, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SAME_AS;
		}
	}

	class IndividualDifferentFromItemParser
			extends AnnotatedIndividualsListItemParser<OWLIndividual> {

		@Override
		public OWLAxiom createAxiom(OWLIndividual s, OWLIndividual o,
				Set<OWLAnnotation> anns) {
			Set<OWLIndividual> individuals = new HashSet<>();
			individuals.add(s);
			individuals.add(o);
			return dataFactory.getOWLDifferentIndividualsAxiom(individuals,
					anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DIFFERENT_FROM;
		}
	}

	class IndividualDifferentIndividualsItemParser implements
			AnnotatedListItemParser<OWLIndividual, Set<OWLIndividual>> {

		@Override
		public Set<OWLIndividual> parseItem(OWLIndividual s) {
			return parseIndividualList();
		}

		@Override
		public OWLAxiom createAxiom(OWLIndividual s, Set<OWLIndividual> o,
				Set<OWLAnnotation> anns) {
			Set<OWLIndividual> individuals = new HashSet<>();
			individuals.add(s);
			individuals.addAll(o);
			return dataFactory.getOWLDifferentIndividualsAxiom(individuals,
					anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DIFFERENT_INDIVIDUALS;
		}
	}

	class IndividualAnnotationItemParser
			implements AnnotatedListItemParser<OWLIndividual, OWLAnnotation> {

		@Override
		public OWLAnnotation parseItem(OWLIndividual s) {
			return parseAnnotation();
		}

		@Override
		public OWLAxiom createAxiom(OWLIndividual s, OWLAnnotation o,
				Set<OWLAnnotation> anns) {
			if (s.isAnonymous()) {
				return dataFactory.getOWLAnnotationAssertionAxiom(
						s.asOWLAnonymousIndividual(), o, anns);
			} else {
				return dataFactory.getOWLAnnotationAssertionAxiom(
						s.asOWLNamedIndividual().getIRI(), o, anns);
			}
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return ANNOTATIONS;
		}
	}

	abstract class AnnotatedIRIListItemParser<F>
			implements AnnotatedListItemParser<F, IRI> {

		@Override
		public IRI parseItem(F s) {
			return parseIRI();
		}
	}

	class AnnotationPropertySubPropertyOfListItemParser implements
			AnnotatedListItemParser<OWLAnnotationProperty, OWLAnnotationProperty> {

		@Override
		public OWLAnnotationProperty parseItem(OWLAnnotationProperty s) {
			return parseAnnotationProperty();
		}

		@Override
		public OWLAxiom createAxiom(OWLAnnotationProperty s,
				OWLAnnotationProperty o, Set<OWLAnnotation> anns) {
			return dataFactory.getOWLSubAnnotationPropertyOfAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return SUB_PROPERTY_OF;
		}
	}

	class AnnotationPropertyDomainListItemParser
			extends AnnotatedIRIListItemParser<OWLAnnotationProperty> {

		@Override
		public OWLAxiom createAxiom(OWLAnnotationProperty s, IRI o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLAnnotationPropertyDomainAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return DOMAIN;
		}
	}

	class AnnotationPropertyRangeListItemParser
			extends AnnotatedIRIListItemParser<OWLAnnotationProperty> {

		@Override
		public OWLAxiom createAxiom(OWLAnnotationProperty s, IRI o,
				Set<OWLAnnotation> anns) {
			return dataFactory.getOWLAnnotationPropertyRangeAxiom(s, o, anns);
		}

		@Override
		public ManchesterOWLSyntax getFrameSectionKeyword() {
			return RANGE;
		}
	}
}
