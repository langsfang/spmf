package ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.savers;

import java.util.Collection;

import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.dataStructures.patterns.Pattern;

/**
 * This is the definition of a interface in order to decide where the user wants
 * to keep the ca.pfv.spmf.patterns. The implementer classes will refer to the place for
 * keeping them
 *
 * Copyright Antonio Gomariz Peñalver 2013
 *
 * This file is part of the SPMF DATA MINING SOFTWARE
 * (http://www.philippe-fournier-viger.com/spmf).
 *
 * SPMF is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SPMF is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SPMF. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author agomariz
 */
public interface Saver {

    /**
     * Save ca.pfv.spmf.patterns to file
     * @param p a pattern
     */
    public void savePattern(Pattern p);

    public void finish();

    public void clear();

    /**
     * Print ca.pfv.spmf.patterns
     * @return a string
     */
    public String print();

    /**
     * Save ca.pfv.spmf.patterns to file
     * @param patterns a list of ca.pfv.spmf.patterns
     */
    public void savePatterns(Collection<Pattern> patterns);


}